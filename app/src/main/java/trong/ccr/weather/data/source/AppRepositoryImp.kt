package trong.ccr.weather.data.source

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.data.source.local.LocalDataSource
import trong.ccr.weather.data.source.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@FlowPreview
@Singleton
class AppRepositoryImp @Inject constructor(private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource) : AppRepository {

    override fun searchWeathers(text: String): Flow<Resource<List<Weather>>> {
        return networkBoundResource(
            query = { localDataSource.list() },
            fetch = { remoteDataSource.searchWeathers(text) },
            saveFetchResult = { localDataSource.insert(it) },
            onFetchFailed = {
                localDataSource.delete()
            }
        )
    }

    override fun getWeather(id: Int): Flow<Weather> {
        return localDataSource.getWeather(id)
    }
}