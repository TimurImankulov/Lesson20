package com.example.lesson20.ui.main

import android.location.Location
import androidx.lifecycle.LiveData
import com.example.lesson20.data.model.ForecastModel
import com.example.lesson20.ui.LiveCycle

interface MainContract {

    interface View{
        fun hideProgressBar()
    }

    interface Presenter:LiveCycle<View>{
        fun loadByLocation(location: Location, string: String)
        fun getSavedData() :  LiveData<List<ForecastModel>>?
    }
}