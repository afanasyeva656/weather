package com.afanasyeva656.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.afanasyeva656.weather.feature.settings_screen.ui.SettingsScreenActivity
import com.afanasyeva656.weather.feature.weather_screen.ui.WeatherScreenActivity

class MainActivity : AppCompatActivity() {
//    private val presenter = SettingsInteractor()
//    Bad things:
//    private val settingsRepo: SettingsRepo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherButton = findViewById<Button>(R.id.weatherButton)
        weatherButton.setOnClickListener {
            Intent(this, WeatherScreenActivity::class.java).also { startActivity(it) }
        }

        val settingsButton = findViewById<Button>(R.id.settingsButton)
        settingsButton.setOnClickListener {
            Intent(this, SettingsScreenActivity::class.java).also { startActivity(it) }
        }
    }
}