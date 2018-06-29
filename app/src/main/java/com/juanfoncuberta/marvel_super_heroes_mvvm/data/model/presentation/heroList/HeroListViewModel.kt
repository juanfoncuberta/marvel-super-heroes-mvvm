package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v7.widget.DefaultItemAnimator
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm.BaseViewModel
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.MarvelHeroesRepository
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class HeroListViewModel: BaseViewModel(){

    //TODO mejorar dependencias (service locator)
    val marvelHeroesListState: MutableLiveData<List<MarvelHero>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()
    private val fakeMarvelHeroesDataSource = FakeMarvelHeroesDataSource()
    private val marvelHeroesRepository =  MarvelHeroesRepository(fakeMarvelHeroesDataSource)


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
       /* view.showLoading(true)
        getMarvelHeroesList.execute({ heroes ->
            view.showHeroesList(heroes)
            view.showLoading(false)
        }, {
            view.showError(it.toString())
            view.showLoading(false)
        })*/
    }

}