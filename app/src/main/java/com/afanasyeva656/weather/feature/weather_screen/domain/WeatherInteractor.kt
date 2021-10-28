package com.afanasyeva656.weather.feature.weather_screen.domain

import com.afanasyeva656.weather.base.attempt
import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRepo

// можем объединить тут несколько репозиториев
class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(cityName: String) = attempt { repository.getWeather(cityName) }
}