package com.afanasyeva656.weather.feature.settings_screen.domain

import com.afanasyeva656.weather.feature.settings_screen.data.storage.SettingsRepo
import com.afanasyeva656.weather.feature.settings_screen.data.storage.model.SettingsModel

class SettingsInteractor(private val repository: SettingsRepo) {
    suspend fun saveCity(city: String) {
        repository.saveCity(city)
    }

    suspend fun getSettings(): SettingsModel {
        return repository.getSettings()
    }
}