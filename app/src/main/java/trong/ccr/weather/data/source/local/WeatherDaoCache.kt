package trong.ccr.weather.data.source.local

import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.entity.Weather


interface WeatherDaoCache {

    fun list(): Flow<List<Weather>>

    suspend fun insert(list: List<Weather>)
}