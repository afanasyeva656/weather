package com.afanasyeva656.weather.feature.weather_screen.ui

import com.afanasyeva656.weather.base.BaseViewModel
import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.settings_screen.domain.SettingsInteractor
import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel

class WeatherScreenViewModel(
    private val weatherInteractor: WeatherInteractor,
    private val settingsInteractor: SettingsInteractor
) : BaseViewModel<ViewState>() {
    init {
        processUiEvent(UIEvent.RequestWeather)
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            WeatherDomainModel(
                temperature = "0.0",
                temperatureMax = "0.0",
                temperatureMin = "0.0",
                humidity = "0.0",
                windDomainModel = WindDomainModel(0.0, 0)
            ), "City", true, null
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.RequestWeather -> {
                val cityName = settingsInteractor.getSettings().city
                weatherInteractor.getWeather(cityName).fold(
                    onSuccess = { processDataEvent(DataEvent.SuccessWeatherRequest(cityName, it)) },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorWeatherRequest(
                                it.localizedMessage ?: "Error"
                            )
                        )
                    }
                )
            }
            is DataEvent.SuccessWeatherRequest -> {
                return previousState.copy(
                    weatherModel = event.weatherModel,
                    cityName = event.cityName,
                    isLoading = false,
                    error = null
                )
            }
            is DataEvent.ErrorWeatherRequest -> {
                return previousState.copy(
                    isLoading = false,
                    error = event.error
                )
            }
        }
        return null
    }
}
