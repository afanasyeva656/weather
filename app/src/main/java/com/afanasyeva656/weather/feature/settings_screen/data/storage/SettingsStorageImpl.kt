package com.afanasyeva656.weather.feature.settings_screen.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.afanasyeva656.weather.feature.settings_screen.data.storage.model.SettingsModel
import kotlinx.coroutines.flow.*
import java.io.IOException

class SettingsStorageImpl(
    private val dataStore: DataStore<Preferences>,
    private val context: Context
) : SettingsStorage {
    companion object {
        private const val CITY_PREFERENCES = "cityPreferences"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = CITY_PREFERENCES)
    }

    override val settingsPreferences: Flow<SettingsModel> = dataStore.data
        .catch {
            // throws an IOException when an error is encountered when reading data
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            SettingsModel(
                cityName = preferences.cityName
            )
        }
        .distinctUntilChanged()

    override suspend fun saveCity(city: String) {
        context.dataStore.edit {
            it[SettingsScheme.cityName] = city
        }
    }

    override suspend fun getCity(): SettingsModel {
        return SettingsModel(context.dataStore.data.map {
            it[SettingsScheme.cityName]
        }.first() ?: throw IOException("Город не указан!"))
    }
}