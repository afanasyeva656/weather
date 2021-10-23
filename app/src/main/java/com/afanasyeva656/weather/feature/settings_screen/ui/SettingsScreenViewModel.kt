package com.afanasyeva656.weather.feature.settings_screen.ui

import androidx.lifecycle.ViewModel
import com.afanasyeva656.weather.feature.settings_screen.domain.SettingsInteractor

class SettingsScreenViewModel(
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {
    suspend fun saveCity(city: String) {
        settingsInteractor.saveCity(city)
    }
}