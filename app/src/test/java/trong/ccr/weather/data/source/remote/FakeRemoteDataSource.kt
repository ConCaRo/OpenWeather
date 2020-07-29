package trong.ccr.weather.data.source.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Test

import org.junit.Assert.*
import trong.ccr.weather.data.source.entity.Weather

class FakeRemoteDataSource(var weathers: List<Weather> = mutableListOf()) : RemoteSource {
    override fun searchWeathers(text: String): Flow<List<Weather>> {
        return flowOf(weathers)
    }

}