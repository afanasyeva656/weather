package com.afanasyeva656.weather.feature.wind_screen.ui

import com.afanasyeva656.weather.base.BaseViewModel
import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.settings_screen.domain.SettingsInteractor
import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel

class WindScreenViewModel(
    private val weatherInteractor: WeatherInteractor,
    private val settingsInteractor: SettingsInteractor
) : BaseViewModel<ViewState>() {
    init {
        processUiEvent(UIEvent.GetWind)
    }

    override fun initialViewState(): ViewState {
        return ViewState(WindDomainModel(0.0, 0), "")
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.GetWind -> {
                val cityName = settingsInteractor.getSettings().city
                weatherInteractor.getWeather(cityName).fold(
                    onSuccess = { processDataEvent(DataEvent.SuccessWindGetting(it.windDomainModel)) },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorWindGetting(
                                it.localizedMessage ?: "Error"
                            )
                        )
                    }
                )
            }
            is DataEvent.SuccessWindGetting -> {
                return previousState.copy(windDomainModel = event.windDomainModel)
            }
            is DataEvent.ErrorWindGetting -> {
                return previousState.copy(errorMessage = event.error)
            }
        }
        return null
    }
}