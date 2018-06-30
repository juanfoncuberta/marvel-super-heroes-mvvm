package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.db.HeroDatabase
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Flowable
import java.util.*
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalDataSource(val heroDatabase: HeroDatabase): MarvelHeroesDataSource {
    override fun getMarvelHeroesList(): Flowable<List<MarvelHero>> =
        heroDatabase
                .getHeroDao()
                .getAllHeroes()
                .toFlowable()

    fun saveHeroes(heroes: List<MarvelHero>){
        Observable.fromCallable{
                heroDatabase.getHeroDao().insertAll(heroes)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()

    }



}