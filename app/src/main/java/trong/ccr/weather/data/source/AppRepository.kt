package trong.ccr.weather.data.source

import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.entity.Weather

interface AppRepository  {

    fun searchWeathers(text: String): Flow<Resource<List<Weather>>>

    fun getWeather(id: Int): Flow<Weather>
}