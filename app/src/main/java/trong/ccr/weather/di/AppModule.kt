package trong.ccr.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.AppRepositoryImp
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppRepository(appRepository: AppRepositoryImp): AppRepository = appRepository

}