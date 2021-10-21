package com.afanasyeva656.weather.feature.weather_screen.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

class CityDataStorageImpl(private val context: Context): CityDataStorage {
    companion object {
        private const val CITY_PREFERENCES = "cityPreferences"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name=CITY_PREFERENCES)
    }

    override suspend fun saveCity(city: String) {
        context.dataStore.edit {
            it [CityScheme.cityName] = city
        }
    }

    override suspend fun getCity(): String {
        return context.dataStore.data.map {
            it[CityScheme.cityName]
        }.first() ?: throw IOException("Город не указан!")
    }
}