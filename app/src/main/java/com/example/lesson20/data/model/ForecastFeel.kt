package com.example.lesson20.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ForecastFeel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val day : Double,
    val night : Double,
    val eve : Double,
    val morn : Double
)