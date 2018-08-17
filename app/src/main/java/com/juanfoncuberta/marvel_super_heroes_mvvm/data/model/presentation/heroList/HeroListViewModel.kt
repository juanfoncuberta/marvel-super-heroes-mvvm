package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList

import android.arch.lifecycle.MutableLiveData
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.serviceLocator.Inject
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm.BaseViewModel
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.MarvelHeroesRepository
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.ApiDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class HeroListViewModel: BaseViewModel(){

    val marvelHeroesListState: MutableLiveData<List<MarvelHero>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()

    fun loadMarvelHeroes() {
        Inject.marvelHeroesRepository.getMarvelHeroesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {  isLoadingState.postValue(true) }
                .doOnTerminate{ isLoadingState.postValue(false)}
                .subscribeBy (
                    onNext = {
                        marvelHeroesListState.value = it
                     },
                    onError= {

                    },
                    onComplete = {
                            Inject.settingsManager.firstLoad = false
                    }
                ).addTo(compositeDisposable)

    }

    fun updateFavourite(marvelHero: MarvelHero){
        Inject.marvelHeroesRepository
                .updateMarvelHero(marvelHero)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            marvelHeroesListState.value = marvelHeroesListState.value                        },
                        onError = {

                        }
                )
                .addTo(compositeDisposable)
    }

}