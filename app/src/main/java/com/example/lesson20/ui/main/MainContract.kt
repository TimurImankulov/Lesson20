package com.example.lesson20.ui.main

import android.location.Location
import com.example.lesson20.data.model.forecast.ForecastModel
import com.example.lesson20.ui.LiveCycle

interface MainContract {

    interface View{
        fun fillViews(result: ForecastModel?)
        fun hideProgressBar()
    }

    interface Presenter:LiveCycle<View>{
        fun loadByLocation(location: Location, string: String)
    }
}