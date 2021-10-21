package com.afanasyeva656.weather.feature.wind_screen.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.android.viewmodel.ext.android.viewModel


class WindScreenActivity: AppCompatActivity() {
    val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)
        windScreenViewModel.liveData.observe(this, Observer(::render))
        windScreenViewModel.getWind()
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvWindSpeed).let { it.text = state.windDomainModel.speed.toString() }
    }
}