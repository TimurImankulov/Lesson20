package com.example.lesson20.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ForecastModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int,
    val current: ForecastCurrent,
    val minutely: List<MinuteItem>?,
    val hourly: List<HourItem>,
    val daily: List<DayItem>
)




