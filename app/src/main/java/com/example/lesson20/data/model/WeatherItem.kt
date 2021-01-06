package com.example.lesson20.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherItem (
    @PrimaryKey
    val id : Int,
    val main : String,
    val description : String,
    val icon : String
)