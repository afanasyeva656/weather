package com.afanasyeva656.weather.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.settings_screen.data.storage.model.SettingsModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenActivity
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    private val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherScreenViewModel.liveData.observe(this, Observer(::render))
        weatherScreenViewModel.settingsLiveData.observe(this, Observer(::showCityName))

        weatherScreenViewModel.requestWeather()
        weatherScreenViewModel.getSettings()

        val windButton = findViewById<Button>(R.id.buttonWind)
        windButton.setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }
    }

    private fun showCityName(settingsModel: SettingsModel) {
        findViewById<TextView>(R.id.tvCityName).text = settingsModel.city
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvTemperature).text =
            getString(R.string.temperature, state.temperature)
        findViewById<TextView>(R.id.tvTemperatureMin).text =
            getString(R.string.temperature_min, state.temperatureMin)
        findViewById<TextView>(R.id.tvTemperatureMax).text =
            getString(R.string.temperature_max, state.temperatureMax)
        findViewById<TextView>(R.id.tvHumidity).text =
            getString(R.string.humidity, state.humidity)
    }
}