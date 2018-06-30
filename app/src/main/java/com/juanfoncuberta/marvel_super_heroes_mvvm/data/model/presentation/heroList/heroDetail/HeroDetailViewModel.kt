package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.heroDetail

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.serviceLocator.Inject
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm.BaseViewModel
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.MarvelHeroesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class HeroDetailViewModel(): BaseViewModel() {

    val heroState: MutableLiveData<MarvelHero> = MutableLiveData()
    fun loadHeroByName(heroName:String){

       Inject.marvelHeroesRepository.getMarvelHeroDetail(heroName)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeBy(
                   onNext= {
                       heroState.value = it
                   },
                   onError = {

                   }
               ).addTo(compositeDisposable)
    }
}