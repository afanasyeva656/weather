package com.afanasyeva656.weather.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenActivity
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity: AppCompatActivity() {
    private val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherScreenViewModel.liveData.observe(this, Observer(::render))
        weatherScreenViewModel.requestWeather()

        val windButton = findViewById<Button>(R.id.windButton)
        windButton.setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvTemperature).let { it.text = state.temperature }
        findViewById<TextView>(R.id.tvTemperatureMin).let { it.text = state.temperatureMin }
        findViewById<TextView>(R.id.tvTemperatureMax).let { it.text = state.temperatureMax }
        findViewById<TextView>(R.id.tvHumidity).let { it.text = state.humidity }
    }
}