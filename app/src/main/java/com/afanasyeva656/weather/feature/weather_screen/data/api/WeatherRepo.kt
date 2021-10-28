package com.afanasyeva656.weather.feature.weather_screen.data.api

import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepo {
    suspend fun getWeather(cityName: String): WeatherDomainModel
}