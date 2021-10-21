package com.afanasyeva656.weather.feature.weather_screen.data.storage

class SettingsRepoImpl(private val dataStorage: CityDataStorage): SettingsRepo {
    override suspend fun saveCity(city: String) {
        dataStorage.saveCity(city)
    }

    override suspend fun getCity(): String {
        return dataStorage.getCity()
    }
}