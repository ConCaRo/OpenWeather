package trong.ccr.weather.data.source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import trong.ccr.weather.data.source.local.AppDatabase.Companion.TABLE_WEATHER

@Entity(tableName = TABLE_WEATHER)
data class Weather(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val name: String,
    val date: String,
    val temperature: String,
    val pressure: String,
    val humidity: String,
    val description: String?
)

data class WeatherResponse(
    val list: List<WeatherList>,
    val city: WeatherCity
)

data class WeatherList(
    val main: WeatherMain,
    val weather: List<WeatherDescription>,
    val dt_txt: String
)

data class WeatherMain(
    val temp: String,
    val pressure: String,
    val humidity: String
)

data class WeatherDescription(
    val main: String,
    val description: String
)

data class WeatherCity(
    val name: String,
    val country: String
)

fun WeatherResponse.mapToWeathers() : List<Weather> {
    return this.list.mapIndexedNotNull { index, item ->
        Weather(
            index,
            this.city.name,
            item.dt_txt,
            item.main.temp,
            item.main.pressure,
            item.main.humidity,
            item.weather[0]?.description
        )
    }
}