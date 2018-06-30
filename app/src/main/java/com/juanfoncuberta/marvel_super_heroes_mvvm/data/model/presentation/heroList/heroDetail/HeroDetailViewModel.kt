package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.heroDetail

import android.arch.lifecycle.MutableLiveData
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm.BaseViewModel


class HeroDetailViewModel(): BaseViewModel() {

    val heroState: MutableLiveData<MarvelHero> = MutableLiveData()

}