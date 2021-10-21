package com.afanasyeva656.weather.feature.weather_screen.data.storage

import android.content.Context

interface CityDataStorage {
    suspend fun saveCity(city: String)
    suspend fun getCity(): String
}