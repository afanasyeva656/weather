package com.afanasyeva656.weather.feature.weather_screen.data.api

import com.afanasyeva656.weather.feature.weather_screen.data.toDomain
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel

class WeatherRepoImpl(private val source: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getWeather(cityName: String): WeatherDomainModel {
        return source.getWeather(cityName).toDomain()
    }
}