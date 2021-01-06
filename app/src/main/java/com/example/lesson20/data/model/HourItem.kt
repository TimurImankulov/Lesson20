package com.example.lesson20.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HourItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val dt: Int,
    val temp: Double,
    val feels_like: Double,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Double,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Double,
    val wind_deg: Int,
    val pop: Double,
    val weather: List<WeatherItem>
)