package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource

import android.util.Log
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.ApiDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import io.reactivex.Flowable
import io.reactivex.Observable

class MarvelHeroesRepository(private val fakeMarvelHeroesDataSource: FakeMarvelHeroesDataSource,private val apiDataSource: ApiDataSource) {

     fun getMarvelHeroesList(): Flowable<List<MarvelHero>> {

          var data = apiDataSource.getMarvelHeroesList()
          Log.d("DENTROOOOOS", data.toString() )
          return  data
     }


             /*fakeMarvelHeroesDataSource.getMarvelHeroesList()
               .mergeWith(apiDataSource.getMarvelHeroesList())
     */



}