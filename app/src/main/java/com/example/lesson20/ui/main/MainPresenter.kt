package com.example.lesson20.ui.main

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.lesson20.WeatherApp
import com.example.lesson20.data.model.ForecastModel
import com.example.lesson20.data.remote.RetrofitBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter:MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun loadByLocation(location: Location, key: String) {
        GlobalScope.launch {
            runCatching {
                val result = RetrofitBuilder.getService()?.getForecastByCoordinates(
                    location.latitude.toString(), location.longitude.toString(), "minutely",
                    key, "metric")

                updateDB(result)
            }.onFailure {
                Log.e("NETWORK", "NO DATA")
                view?.hideProgressBar()
            }
        }
    }

    override fun getSavedData(): LiveData<List<ForecastModel>>? {
        return WeatherApp.getApp()?.getDB()?.getDao()?.getAll()
    }

    private fun updateDB(result: ForecastModel?) {
        result?.let {
            WeatherApp.getApp()?.getDB()?.getDao()?.addForcast(it)
        }
    }

    override fun bind(view: MainContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }
}