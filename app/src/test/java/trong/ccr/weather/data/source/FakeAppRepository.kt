package trong.ccr.weather.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import trong.ccr.weather.data.source.entity.Weather

class FakeAppRepository(var weathers: List<Weather> = mutableListOf()) : AppRepository {

    override fun searchWeathers(text: String): Flow<Resource<List<Weather>>> {
        return flowOf(Resource.success(weathers))
    }

    override fun getWeather(id: Int): Flow<Weather> {
        return flowOf(weathers.first())
    }
}