package trong.ccr.weather.data.source

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import trong.ccr.weather.BaseTest
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.data.source.local.FakeLocalDataSource
import trong.ccr.weather.data.source.remote.FakeRemoteDataSource
import trong.ccr.weather.features.search.SearchViewModel.Companion.DEFAULT_PLACE
import trong.ccr.weather.test

class AppRepositoryImpTest: BaseTest() {

    private lateinit var repository: AppRepositoryImp
    private val listLocal = arrayListOf(weather1, weather2, weather3)
    private val listRemote = arrayListOf(weather2, weather3)
    private val localSource = FakeLocalDataSource(listLocal)
    private val remoteSource = FakeRemoteDataSource(listRemote)

    @Before
    fun createRepository() {
        super.init()
        repository = AppRepositoryImp(localSource, remoteSource)
    }

    @Test
    fun `test searchWeathers return Success`() = runBlockingTest {
        repository.searchWeathers(DEFAULT_PLACE).test(this).assertValues(
            Resource.loading(null), Resource.loading(listLocal), Resource.success(listRemote)
        ).finish()
    }

    @Test
    fun `test getWeather return weather from DB`() = runBlockingTest {
        repository.getWeather(2).test(this).assertValues(
            weather2
        ).finish()
    }


    // TODO: check again: error ClassCastException
    /*@Test
    fun `test searchWeathers return Fail`() = runBlockingTest {
        // when
        val remoteDataSourceMock = Mockito.mock(RemoteSource::class.java)
        val error = Throwable("404 not found")
        Mockito.`when`(remoteDataSourceMock.searchWeathers(DEFAULT_PLACE)).thenAnswer { error }
        val repository = AppRepositoryImp(localSource, remoteDataSourceMock)
        // Then
        repository.searchWeathers(DEFAULT_PLACE).test(this).assertValues(
            Resource.loading(null), Resource.loading(listLocal), Resource.error(error,  null)
        ).finish()
    }*/

    companion object {
        val weather1 = Weather(1, "name", "date", "temp", "pressure", "humidity", "description")
        val weather2 = Weather(2, "name", "date", "temp", "pressure", "humidity", "description")
        val weather3 = Weather(3, "name", "date", "temp", "pressure", "humidity", "description")
    }
}