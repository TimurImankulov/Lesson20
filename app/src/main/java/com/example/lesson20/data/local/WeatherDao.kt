package com.example.lesson20.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lesson20.data.model.ForecastModel

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(data : ForecastModel)

    @Query("SELECT * FROM ForecastModel")
    fun getAll(): LiveData<List<ForecastModel>>

    @Query("DELETE FROM ForecastModel")
    fun deleteAll()

    @Transaction
    fun addForcast(data : ForecastModel){
        deleteAll()
        add(data)
    }
}