package com.afanasyeva656.weather.feature.settings_screen.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.settings_screen.data.storage.model.SettingsModel
import org.koin.android.viewmodel.ext.android.viewModel

class SettingsScreenActivity: AppCompatActivity() {
    private val settingsScreenViewModel by viewModel<SettingsScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val applyButton = findViewById<Button>(R.id.bApplySettings)
        settingsScreenViewModel.liveData.observe(this, Observer(::render))
        settingsScreenViewModel.getSettings()

        applyButton.setOnClickListener {
            val newCityName = findViewById<EditText>(R.id.etCityName).text.toString()
            settingsScreenViewModel.saveCity(newCityName)
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun render(state: SettingsModel) {
        findViewById<EditText>(R.id.etCityName).setText(state.city)
    }
}