package trong.ccr.weather.features.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import trong.ccr.weather.BaseTest
import trong.ccr.weather.MainCoroutineRule
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.FakeAppRepository
import trong.ccr.weather.data.source.Resource
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.features.search.SearchViewModel.Companion.DEFAULT_PLACE

class SearchViewModelTest : BaseTest() {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var appRepository: AppRepository

    @Mock
    private lateinit var weathers: Observer<Resource<List<Weather>>>

    @Mock
    private lateinit var observeQuery: Observer<String>

    private lateinit var searchViewModel: SearchViewModel

    private val weatherData = arrayListOf(
        weather1
    )

    @Before
    override fun init() {
        super.init()
        appRepository = FakeAppRepository(weatherData)
    }

    // TODO: need to fixed mock flow data here to test asFlow and asLiveData
    @Test
    fun `searchWeathers return success`() = runBlockingTest {
        searchViewModel = SearchViewModel(appRepository)

        searchViewModel.weather.observeForever(weathers)
        searchViewModel.observeQuery.observeForever(observeQuery)

        Mockito.verify(observeQuery).onChanged(DEFAULT_PLACE)
        advanceTimeBy(600)
        Mockito.verify(weathers).onChanged(Resource.success(weatherData))
    }

    companion object {
        val weather1 = Weather(1, "name", "date", "temp", "pressure", "humidity", "description")
    }
}