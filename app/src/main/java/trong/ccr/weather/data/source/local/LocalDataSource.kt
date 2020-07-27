package trong.ccr.weather.data.source.local

import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.entity.Weather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val weatherDao: WeatherDao) : AppRepository {

    override fun searchWeathers(text: String): Flow<List<Weather>> {
        TODO("Not yet implemented")
    }
}