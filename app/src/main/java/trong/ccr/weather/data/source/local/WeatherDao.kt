package trong.ccr.weather.data.source.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.data.source.local.AppDatabase.Companion.TABLE_WEATHER

@Dao
interface WeatherDao {

    @Query("SELECT * FROM $TABLE_WEATHER WHERE name LIKE :text")
    fun search(text: String): Flow<List<Weather>>
}