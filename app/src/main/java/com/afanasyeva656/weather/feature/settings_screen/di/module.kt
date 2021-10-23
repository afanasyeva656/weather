package com.afanasyeva656.weather.feature.settings_screen.di

import com.afanasyeva656.weather.feature.settings_screen.domain.SettingsInteractor
import com.afanasyeva656.weather.feature.settings_screen.data.storage.SettingsRepo
import com.afanasyeva656.weather.feature.settings_screen.data.storage.SettingsRepoImpl
import com.afanasyeva656.weather.feature.settings_screen.data.storage.SettingsStorage
import com.afanasyeva656.weather.feature.settings_screen.data.storage.SettingsStorageImpl
import com.afanasyeva656.weather.feature.settings_screen.ui.SettingsScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsModule = module {
    single<SettingsStorage> {
        SettingsStorageImpl(androidContext())
    }

    single<SettingsRepo> {
        SettingsRepoImpl(get<SettingsStorage>())
    }

    single<SettingsInteractor> {
        SettingsInteractor(get<SettingsRepo>())
    }

    viewModel{
        SettingsScreenViewModel(get<SettingsInteractor>())
    }
}