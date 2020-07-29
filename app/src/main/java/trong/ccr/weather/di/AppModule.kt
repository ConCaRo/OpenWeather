package trong.ccr.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.AppRepositoryImp
import trong.ccr.weather.data.source.local.LocalDataSource
import trong.ccr.weather.data.source.local.LocalSource
import trong.ccr.weather.data.source.remote.RemoteDataSource
import trong.ccr.weather.data.source.remote.RemoteSource
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideLocalSource(localDataSource: LocalDataSource): LocalSource = localDataSource

    @Provides
    @Singleton
    fun provideRemoteSource(remoteDataSource: RemoteDataSource): RemoteSource = remoteDataSource

    @Provides
    @Singleton
    fun provideAppRepository(appRepository: AppRepositoryImp): AppRepository = appRepository


}