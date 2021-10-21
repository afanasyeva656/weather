package com.afanasyeva656.weather.feature.weather_screen.data.storage

interface SettingsRepo {
    suspend fun saveCity(city: String)
    suspend fun getCity(): String
}