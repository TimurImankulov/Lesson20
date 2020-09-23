package com.example.lesson20.ui.main

import android.location.Location
import android.util.Log
import com.example.lesson20.data.model.RetrofitBuilder
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

                view?.fillViews(result)
            }.onFailure {
                Log.e("NETWORK", "NO DATA")
                view?.hideProgressBar()
            }
        }
    }

    override fun bind(view: MainContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }
}