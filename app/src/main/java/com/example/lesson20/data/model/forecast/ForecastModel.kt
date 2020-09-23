package com.example.lesson20.data.model.forecast

data class ForecastModel (
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int,
    val current: ForecastCurrent,
    val minutely: List<MinuteItem>,
    val hourly: List<HourItem>,
    val daily: List<DayItem>
)




