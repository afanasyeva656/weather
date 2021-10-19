package com.afanasyeva656.weather.feature.weather_screen.data.api

import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel

interface WeatherRepo {
    suspend fun getWeather(): WeatherDomainModel
}