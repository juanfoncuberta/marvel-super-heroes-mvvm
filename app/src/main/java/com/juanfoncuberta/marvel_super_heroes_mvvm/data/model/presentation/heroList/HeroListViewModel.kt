package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v7.widget.DefaultItemAnimator
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm.BaseViewModel
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.MarvelHeroesRepository
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource2
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class HeroListViewModel: BaseViewModel(){

    //TODO mejorar dependencias (service locator)
    val marvelHeroesListState: MutableLiveData<List<MarvelHero>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()
    private val fakeMarvelHeroesDataSource = FakeMarvelHeroesDataSource()
    private val fakeMarvelHeroesDataSource2 = FakeMarvelHeroesDataSource2()
    private val marvelHeroesRepository =  MarvelHeroesRepository(fakeMarvelHeroesDataSource,fakeMarvelHeroesDataSource2)


    fun loadMarvelHeroes() {
        marvelHeroesRepository.getMarvelHeroesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {  isLoadingState.postValue(true) }
                .doOnTerminate{ isLoadingState.postValue(false)}
                .subscribeBy (
                    onNext = {
                        marvelHeroesListState.value = it
                     },
                    onError= {

                    }
                ).addTo(compositeDisposable)

    }

}