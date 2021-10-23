package com.afanasyeva656.weather.feature.settings_screen.data.storage

import com.afanasyeva656.weather.feature.settings_screen.data.storage.model.SettingsModel

class SettingsRepoImpl(private val dataStorage: SettingsStorage): SettingsRepo {
    override suspend fun saveCity(city: String) {
        dataStorage.saveCity(city)
    }

    override suspend fun getSettings(): SettingsModel {
        return dataStorage.getSettings()
    }
}