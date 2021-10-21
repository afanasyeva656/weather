package com.afanasyeva656.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.afanasyeva656.weather.feature.weather_screen.data.storage.SettingsRepo
import com.afanasyeva656.weather.feature.weather_screen.data.storage.SettingsRepoImpl
import com.afanasyeva656.weather.feature.weather_screen.ui.WeatherScreenActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val presenter = SettingsInteractor()
//    Bad things:
    private val settingsRepo: SettingsRepo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val textView = findViewById<TextView>(R.id.textView)
//        textView.text = presenter.getTemperature()
//
//        val list = listOf<Int>(1, 2, 3, 4)
//        val filteredList: List<Int>? = null
//        Log.d("test_list", "$filteredList")
//
//        filteredList?.let { textView.text = it.toString() }
//        filteredList?.let { list -> textView.text = list.toString() }
        val weatherButton = findViewById<Button>(R.id.weatherButton)
        weatherButton.setOnClickListener {
            settingsRepo.saveCity("Moscow")
            Intent(this, WeatherScreenActivity::class.java).also { startActivity(it) }
        }
    }
}