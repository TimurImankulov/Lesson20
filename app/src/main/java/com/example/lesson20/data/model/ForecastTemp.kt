package com.example.lesson20.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ForecastTemp (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val day : Double,
    val min : Double,
    val max : Double,
    val night : Double,
    val eve : Double,
    val morn : Double
)