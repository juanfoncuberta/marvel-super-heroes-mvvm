package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource

import android.util.Log
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource2
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MarvelHeroesRepository(private val fakeMarvelHeroesDataSource: FakeMarvelHeroesDataSource,private val fakeMarvelHeroesDataSource2: FakeMarvelHeroesDataSource2) {

     fun getMarvelHeroesList(): Observable<List<MarvelHero>> =
             fakeMarvelHeroesDataSource.getMarvelHeroesList()
               .mergeWith(fakeMarvelHeroesDataSource2.getMarvelHeroesList())


     fun getMarvelHeroDetail(heroName: String): Observable<MarvelHero> =
         /*    fakeMarvelHeroesDataSource.getMarvelHeroDetail(heroName)
                     .concatWith(fakeMarvelHeroesDataSource2.getMarvelHeroDetail(heroName))*/

             fakeMarvelHeroesDataSource.getMarvelHeroDetail(heroName)
                    .switchIfEmpty(fakeMarvelHeroesDataSource2.getMarvelHeroDetail(heroName))



}