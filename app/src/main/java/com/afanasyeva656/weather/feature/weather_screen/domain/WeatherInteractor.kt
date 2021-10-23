package com.afanasyeva656.weather.feature.weather_screen.domain

import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRepo
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel

// можем объединить тут несколько репозиториев
class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(cityName: String): WeatherDomainModel {
        return repository.getWeather(cityName)
    }
}