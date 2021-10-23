package com.afanasyeva656.weather.feature.settings_screen.data.storage

import androidx.datastore.preferences.core.stringPreferencesKey

object SettingsScheme {
    val city = stringPreferencesKey("cityName")
}