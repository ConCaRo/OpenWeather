package trong.ccr.weather.data.source

import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.data.source.local.LocalDataSource
import trong.ccr.weather.data.source.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImp @Inject constructor(private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource) : AppRepository {

    override fun searchWeathers(text: String): Flow<List<Weather>> {
        return remoteDataSource.searchWeathers(text)
    }
}