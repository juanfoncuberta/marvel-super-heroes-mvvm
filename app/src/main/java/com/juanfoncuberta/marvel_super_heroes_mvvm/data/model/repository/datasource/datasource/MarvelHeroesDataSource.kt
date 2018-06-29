package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Observable

interface MarvelHeroesDataSource {

    fun getMarvelHeroesList(): Observable<List<MarvelHero>>
    fun getMarvelHeroDetail(heroId: Long): Observable<MarvelHero>
}