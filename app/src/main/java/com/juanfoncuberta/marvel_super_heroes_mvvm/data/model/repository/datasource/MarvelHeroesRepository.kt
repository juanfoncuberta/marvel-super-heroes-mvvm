package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MarvelHeroesRepository(private val fakeMarvelHeroesDataSource: FakeMarvelHeroesDataSource) {

     fun getMarvelHeroesList(): Observable<List<MarvelHero>> =  fakeMarvelHeroesDataSource.getMarvelHeroesList().delay(1, TimeUnit.SECONDS)



}