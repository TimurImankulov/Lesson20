package com.example.lesson20.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {

    private const val DATE = "d"
    private const val MONTH = "MMMM\nyyyy"
    private const val H_MM = "H:mm"

    fun getDate(): String {
        val sdfDay = SimpleDateFormat(DATE, Locale.getDefault())
        val date = Date()

        return sdfDay.format(date)
    }

    fun getMonth(): String {
        val date = Date()
        val sdfMonth = SimpleDateFormat(MONTH, Locale.getDefault())

        return sdfMonth.format(date)
    }

    fun formatDate(date: Int?): String {
        val newdata = date?.toLong() ?: 0
        return SimpleDateFormat(H_MM, Locale.getDefault()).format(Date(newdata * 1000))
    }
}