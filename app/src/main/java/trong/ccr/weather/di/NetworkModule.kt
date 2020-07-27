package trong.ccr.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import trong.ccr.weather.data.source.remote.BASE_URL
import trong.ccr.weather.data.source.remote.NetworkService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    companion object {
        const val HTTP_CONNECT_TIMEOUT = 30L
        const val HTTP_WRITE_TIMEOUT = 30L
        const val HTTP_READ_TIMEOUT = 60L
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val clientInterceptor = Interceptor { chain ->
            var request: Request = chain.request()
            val url: HttpUrl = request.url().newBuilder()
                .addQueryParameter("appid", "ad5137845b6cea1ec357c406a8880a3d")
                .addQueryParameter("cnt", "7")
                .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }
        val builder = OkHttpClient.Builder()
            .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(clientInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideWeatherService(okHttpClient: OkHttpClient): NetworkService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(NetworkService::class.java)
    }
}