package com.afanasyeva656.weather

import android.app.Application
import com.afanasyeva656.weather.feature.weather_screen.di.appModule
import com.afanasyeva656.weather.feature.wind_screen.di.windModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(listOf<Module>(appModule, windModule))
        }
    }
}