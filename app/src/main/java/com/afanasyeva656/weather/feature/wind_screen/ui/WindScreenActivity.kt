package com.afanasyeva656.weather.feature.wind_screen.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel
import org.koin.android.viewmodel.ext.android.viewModel


class WindScreenActivity: AppCompatActivity() {
    private val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_wind_speed)
        windScreenViewModel.liveData.observe(this, Observer(::render))
        windScreenViewModel.requestWind()
    }

    private fun render(state: WindDomainModel) {
        findViewById<TextView>(R.id.tvWindSpeed).text = state.speed.toString()
    }
}