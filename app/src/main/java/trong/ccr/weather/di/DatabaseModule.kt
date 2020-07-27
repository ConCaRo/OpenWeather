package trong.ccr.weather.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import trong.ccr.weather.data.source.local.AppDatabase
import trong.ccr.weather.data.source.local.WeatherDao
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    @Named("DB_NAME")
    fun provideDatabaseName(): String = AppDatabase.DB_NAME

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context, @Named("DB_NAME") dbName: String): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .build()

    @Provides
    @Singleton
    fun provideWeatherDao(appDatabase: AppDatabase): WeatherDao = appDatabase.weatherDao()
}