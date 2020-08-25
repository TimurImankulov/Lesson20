package com.example.lesson20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson20.model.CurrentWeather
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formatDate()

        RetrofitBuilder.getService()
            ?.getWeather("Bishkek", getString(R.string.api_key))
            ?.enqueue(object : Callback<CurrentWeather> {
                override fun onResponse(
                    call: Call<CurrentWeather>,
                    response: Response<CurrentWeather>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()
                        tvCity.text = data?.name.toString()
                        tvWeather.text = data?.main?.temp.toString()
                    }
                }

                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    Toast.makeText(applicationContext, "Нет доступа к данным", Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun formatDate() {
        val sdfDay = SimpleDateFormat("d", Locale.getDefault())
        val date = Date()
        val day = sdfDay.format(date)
        tvDay.text = day

        val sdfMonth = SimpleDateFormat("MMMM\nyyyy", Locale.getDefault())
        val month = sdfMonth.format(date)
        tvMonth.text = month
    }
}