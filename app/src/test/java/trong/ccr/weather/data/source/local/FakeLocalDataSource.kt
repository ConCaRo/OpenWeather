package trong.ccr.weather.data.source.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import trong.ccr.weather.data.source.entity.Weather

class FakeLocalDataSource(var weathers: MutableList<Weather> = mutableListOf()) : LocalSource {
    override fun list(): Flow<List<Weather>> {
        return flowOf(weathers)
    }

    override suspend fun insert(list: List<Weather>) {
        weathers.clear()
        weathers.addAll(list)
    }

    override fun getWeather(id: Int): Flow<Weather> {
        return flowOf(weathers.findLast { it.id == id }!!)
    }

    override suspend fun delete() {
        weathers.clear()
    }
}