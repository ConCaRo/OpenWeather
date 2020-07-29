package trong.ccr.weather.features.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import trong.ccr.weather.BaseTest
import trong.ccr.weather.MainCoroutineRule
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.getOrAwaitValue


class DetailViewModelTest: BaseTest() {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var appRepository: AppRepository
    @Mock
    private lateinit var weather: Observer<Weather>

    private val savedStateHandle = SavedStateHandle(mapOf("id" to 1))
    private lateinit var detailViewModel: DetailViewModel

    @Before
    override fun init() {
        super.init()
    }

    @Test
    fun getWeather()  {
        `when`(appRepository.getWeather(1)).thenReturn(flowOf(weather1))
        detailViewModel = DetailViewModel(savedStateHandle, appRepository)

        detailViewModel.weather.observeForever(weather)
        verify(weather).onChanged(weather1)
    }

    companion object {
        val weather1 = Weather(1, "name", "date", "temp", "pressure", "humidity", "description")
    }
}