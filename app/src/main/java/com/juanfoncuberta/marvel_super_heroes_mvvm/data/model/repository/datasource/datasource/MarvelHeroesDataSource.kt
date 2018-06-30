package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Flowable

interface MarvelHeroesDataSource {

    fun getMarvelHeroesList(): Flowable<List<MarvelHero>>
  //  fun getMarvelHeroDetail(heroName: String): Observable<MarvelHero>
}