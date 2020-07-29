package trong.ccr.weather.data.source.remote

import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.entity.Weather

interface RemoteSource {
    fun searchWeathers(text: String): Flow<List<Weather>>
}