package trong.ccr.weather.data.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.data.source.local.AppDatabase.Companion.TABLE_WEATHER

@Dao
interface WeatherDao {

    @Query("SELECT * FROM $TABLE_WEATHER")
    fun list(): Flow<List<Weather>>

    @Query("SELECT * FROM $TABLE_WEATHER WHERE id = :id")
    fun getWeather(id: Int): Flow<Weather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<Weather>)

    @Query("DELETE FROM $TABLE_WEATHER")
    suspend fun delete()

    @Transaction
    suspend fun update(list: List<Weather>) {
        delete()
        insert(list)
    }
}