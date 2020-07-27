package trong.ccr.weather.data.source.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import trong.ccr.weather.data.source.entity.Weather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val weatherDao: WeatherDao) : WeatherDaoCache {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override fun list(): Flow<List<Weather>> {
        return weatherDao.list()
    }

    override suspend fun insert(list: List<Weather>) {
        withContext(ioDispatcher) {
            launch {
                weatherDao.update(list)
            }
        }
    }
}