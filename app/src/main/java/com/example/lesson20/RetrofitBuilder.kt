package com.example.lesson20

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private var service: WeatherService? = null

    fun getService(): WeatherService? {
        if (service == null)
            service = buildRetrofit()

        return service
    }

    private fun buildRetrofit(): WeatherService {
        val service =
            Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherService::class.java)

        return service
    }
}




