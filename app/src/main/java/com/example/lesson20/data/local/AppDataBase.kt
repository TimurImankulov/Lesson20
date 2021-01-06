package com.example.lesson20.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lesson20.data.model.*


@Database(entities = [DayItem::class, ForecastCurrent::class, ForecastFeel::class, ForecastModel::class,
        ForecastTemp::class, HourItem::class, MinuteItem::class, WeatherItem::class], version = 1, exportSchema = false)
@TypeConverters(value = [TypeConverter::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): WeatherDao
}