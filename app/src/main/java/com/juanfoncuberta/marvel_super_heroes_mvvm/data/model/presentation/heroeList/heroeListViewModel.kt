package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroeList

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.MarvelHeroesRepository
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class heroeListViewModel: ViewModel(){

    val marvelHeroesListState: MutableLiveData<List<MarvelHero>> = MutableLiveData()
    private val fakeMarvelHeroesDataSource = FakeMarvelHeroesDataSource()
    private val marvelHeroesRepository =  MarvelHeroesRepository(fakeMarvelHeroesDataSource)


    fun loadMarvelHeroes() {
        marvelHeroesRepository.getMarvelHeroesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                    onNext = {
                        marvelHeroesListState.value = it
                     },
                    onError= {

                    }
                )
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