package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm

import android.content.SharedPreferences

class SettingsManager(val sharedPreferences: SharedPreferences) {

    companion object {
        const val PREF_FIRST_LOAD = "first_load"
    }

    var firstLoad:Boolean
    get()= sharedPreferences.getBoolean(PREF_FIRST_LOAD,false)
    set(value){
        sharedPreferences.edit()
                .putBoolean(PREF_FIRST_LOAD,value)
                .apply()
    }

}