package com.example.lesson20.utils

import android.content.Context
import android.net.ConnectivityManager

object ConnectionUtils {

    fun isNetworkAvailable(context: Context):Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.activeNetworkInfo!=null && cm.activeNetworkInfo?.isConnected ?: false
    }
}