package com.afanasyeva656.weather.feature.settings_screen.data.storage

import com.afanasyeva656.weather.feature.settings_screen.data.storage.model.SettingsModel
import kotlinx.coroutines.flow.Flow

interface SettingsRepo {
    suspend fun saveCity(city: String)
    suspend fun getCity(): SettingsModel
}