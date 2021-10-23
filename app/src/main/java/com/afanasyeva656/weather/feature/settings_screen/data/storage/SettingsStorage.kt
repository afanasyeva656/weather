package com.afanasyeva656.weather.feature.settings_screen.data.storage

import com.afanasyeva656.weather.feature.settings_screen.data.storage.model.SettingsModel
import kotlinx.coroutines.flow.Flow

interface SettingsStorage {
    val settingsPreferences: Flow<SettingsModel>
    suspend fun saveCity(city: String)
    suspend fun getCity(): SettingsModel
}