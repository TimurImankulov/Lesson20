package com.example.lesson20.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DayItem (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val dt : Int,
    val sunrise : Int,
    val sunset : Int,
    val pressure : Int,
    val humidity : Int,
    val dew_point : Double,
    val wind_speed : Double,
    val wind_deg : Int,
    val clouds : Int,
    val pop : Double,
    val uvi : Double,
    val temp: ForecastTemp,
    val feels_like: ForecastFeel,
    val weather: List<WeatherItem>
)