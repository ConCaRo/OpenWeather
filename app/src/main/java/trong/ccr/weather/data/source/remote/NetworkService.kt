package trong.ccr.weather.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Query
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.data.source.entity.WeatherResponse

interface NetworkService {

    @GET("forecast")
    suspend fun searchWeathers(@Query("q") text: String) : WeatherResponse
}