package com.afanasyeva656.weather.feature.weather_screen.data.storage

import androidx.datastore.preferences.core.stringPreferencesKey

object CityScheme {
    val cityName = stringPreferencesKey("cityName")
}