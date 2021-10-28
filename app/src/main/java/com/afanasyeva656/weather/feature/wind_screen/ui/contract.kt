package com.afanasyeva656.weather.feature.wind_screen.ui

import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel

data class ViewState(
    val windDomainModel: WindDomainModel,
    val errorMessage: String
)

sealed class UIEvent(): Event {
    object GetWind: UIEvent()
}

sealed class DataEvent(): Event {
    data class SuccessWindGetting(val windDomainModel: WindDomainModel): DataEvent()
    data class  ErrorWindGetting(val error: String): DataEvent()
}