package com.afanasyeva656.weather.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    private val viewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        viewModel.viewState.observe(this, Observer(::render))

        val windButton = findViewById<Button>(R.id.buttonWind)
        windButton.setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }
    }

    private fun render(state: ViewState) {
        findViewById<TextView>(R.id.tvCityName).text = state.cityName
        findViewById<TextView>(R.id.tvTemperature).text =
            getString(R.string.temperature, state.weatherModel.temperature)
        findViewById<TextView>(R.id.tvTemperatureMin).text =
            getString(R.string.temperature_min, state.weatherModel.temperatureMin)
        findViewById<TextView>(R.id.tvTemperatureMax).text =
            getString(R.string.temperature_max, state.weatherModel.temperatureMax)
        findViewById<TextView>(R.id.tvHumidity).text =
            getString(R.string.humidity, state.weatherModel.humidity)

        updateProgressBar(state.isLoading)
        renderError(state.error)
    }

    private fun updateProgressBar(isLoading: Boolean) {
        findViewById<ProgressBar>(R.id.progressBar).visibility =
            if (isLoading) View.VISIBLE else View.GONE
    }

    private fun renderError(error: String?) {
        error?.let {
            Snackbar.make(findViewById(android.R.id.content), it, Snackbar.LENGTH_LONG).show()
        }
    }
}