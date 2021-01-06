package com.example.lesson20.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MinuteItem (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val dt : Int,
    val precipitation : Int
)