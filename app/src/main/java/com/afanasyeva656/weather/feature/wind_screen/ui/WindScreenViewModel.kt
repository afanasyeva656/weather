package com.afanasyeva656.weather.feature.wind_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel
import kotlinx.coroutines.launch

class WindScreenViewModel(private val weatherInteractor: WeatherInteractor): ViewModel() {
    val liveData: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun getWind() {
        viewModelScope.launch {
            liveData.postValue(weatherInteractor.getWeather("Moscow"))
        }
    }
}