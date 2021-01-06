package com.example.lesson20.data.local

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.room.TypeConverter
import com.example.lesson20.data.model.*


object TypeConverter {

    @JvmStatic
    @TypeConverter
    fun dayItemToString(model: List<DayItem>): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun dayItemToObject(text: String?): List<DayItem>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<DayItem>>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun forecastCurrentToString(model: ForecastCurrent): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun forecastCurrentToObject(text: String): ForecastCurrent? {
        if (TextUtils.isEmpty(text))
            return null
        return Gson().fromJson(text, ForecastCurrent::class.java)
    }

    @JvmStatic
    @TypeConverter
    fun forecastFeelToString(model: ForecastFeel): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun forecastFeelToObject(text: String): ForecastFeel? {
        if (TextUtils.isEmpty(text))
            return null
        return Gson().fromJson(text, ForecastFeel::class.java)
    }

    @JvmStatic
    @TypeConverter
    fun forecastTempToString(model: ForecastTemp): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun forecastTempToObject(text: String): ForecastTemp? {
        if (TextUtils.isEmpty(text))
            return null
        return Gson().fromJson(text, ForecastTemp::class.java)
    }

    @JvmStatic
    @TypeConverter
    fun hourItemToString(model: List<HourItem>): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun hourItemToObject(text: String?): List<HourItem>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<HourItem>>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun minuteItemToString(model: List<MinuteItem>): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun minuteItemToObject(text: String?): List<MinuteItem>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<MinuteItem>>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun weatherItemToString(model: List<WeatherItem>): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun weatherItemToObject(text: String?): List<WeatherItem>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<WeatherItem>>() {}.type
        return Gson().fromJson(text, typeToken)
    }
}
