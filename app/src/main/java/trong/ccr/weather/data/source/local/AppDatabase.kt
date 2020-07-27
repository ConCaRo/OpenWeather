package trong.ccr.weather.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import trong.ccr.weather.data.source.entity.Weather

@Database(
    entities = [Weather::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "weather.db"
        const val TABLE_WEATHER = "table_weather"
    }

    abstract fun weatherDao(): WeatherDao
}