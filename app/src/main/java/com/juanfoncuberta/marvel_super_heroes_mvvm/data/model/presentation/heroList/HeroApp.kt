package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList

import android.app.Application
import android.preference.PreferenceManager
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.serviceLocator.Inject
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm.SettingsManager

class HeroApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Inject.settingsManager = SettingsManager(PreferenceManager.getDefaultSharedPreferences(this))
    }
}