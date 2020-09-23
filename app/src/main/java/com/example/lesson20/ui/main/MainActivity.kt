package com.example.lesson20.ui.main

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lesson20.R
import com.example.lesson20.data.model.RvAdapter
import com.example.lesson20.data.model.forecast.ForecastModel
import com.example.lesson20.utils.ConnectionUtils
import com.example.lesson20.utils.DateTimeUtils
import com.example.lesson20.utils.PermissionUtils
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter by lazy { RvAdapter() }
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter?.bind(this)

        checkPermissions()
        formatDate()
        setupRecycler()
        showSnackBar()
    }

    private fun setupRecycler() {
        recyclerView.adapter = adapter
    }

    private fun formatDate() {
        tvDay.text = DateTimeUtils.getDate()
        tvMonth.text = DateTimeUtils.getMonth()
    }

    private fun showSnackBar() {
        val isHasNetwork = ConnectionUtils.isNetworkAvailable(this)
        if (!isHasNetwork) {
            Snackbar.make(
                parentLayout,
                getString(R.string.network_error),
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction(getString(R.string.update)) {
                    if (!ConnectionUtils.isNetworkAvailable(this)) {
                        showSnackBar()
                    } else {
                        checkPermissions()
                    }
                }.show()
        }
    }

    fun loadByLocation(location: Location) {
        presenter?.loadByLocation(location, getString(R.string.api_key))
    }

    private fun checkPermissions() {
        if (PermissionUtils.checkLocationPermission(this))
            loadLocation()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionUtils.LOCATION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED)
                loadLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun loadLocation() {
        val fpc = LocationServices.getFusedLocationProviderClient(applicationContext)

        fpc.lastLocation.addOnSuccessListener {
            loadByLocation(it)
        }.addOnFailureListener {
            val location = Location("")
            location.latitude = 42.78
            location.longitude = 75.69
            loadByLocation(location)
        }
    }

    override fun fillViews(result: ForecastModel?) {
        runOnUiThread {
            adapter.update(result?.daily)
            tvLocation.text = result?.timezone
            tvCurrentTemp.text =
                getString(R.string.degreeformat, result?.current?.temp?.toInt().toString())
            tvFeelsTemp.text =
                getString(R.string.degreeformat, result?.current?.feels_like?.toInt().toString())
            tvWindDesc.text =
                getString(R.string.windformat, result?.current?.wind_speed?.toInt().toString())
            tvHumidityDesc.text = getString(R.string.percentformat, result?.current?.humidity)
            tvPressureDesc.text =
                getString(R.string.pressureformat, result?.current?.pressure.toString())
            tvCloudinessDesc.text = getString(R.string.percentformat, result?.current?.clouds)
            tvSunriseDesc.text = DateTimeUtils.formatDate(result?.current?.sunrise)
            tvSunsetDesc.text = DateTimeUtils.formatDate(result?.current?.sunset)

            tvCurrentWeatherDesc.text = result?.current?.weather?.first()?.description
            val image = result?.current?.weather?.first()?.icon
            Picasso.get().load("http://openweathermap.org/img/w/$image.png").into(ivWeatherImage)

            hideProgressBar()
        }
    }

    override fun hideProgressBar() {
        runOnUiThread {
            progressBar.visibility = View.GONE
            nestedScrollView.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unbind()
    }
}