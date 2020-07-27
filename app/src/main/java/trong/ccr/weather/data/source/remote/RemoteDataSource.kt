package trong.ccr.weather.data.source.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.data.source.entity.mapToWeathers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val networkService: NetworkService) : AppRepository {

    override fun searchWeathers(text: String): Flow<List<Weather>> {
        return flow {
            emit(networkService.searchWeathers(text).mapToWeathers())
        }
    }

}