package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource

import android.util.Log
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.ApiDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.LocalDataSource
import io.reactivex.Flowable
import io.reactivex.Observable

class MarvelHeroesRepository(private val apiDataSource: ApiDataSource,private val localDataSource: LocalDataSource) {

     fun getMarvelHeroesList(): Flowable<List<MarvelHero>> =
             localDataSource.getMarvelHeroesList().mergeWith(apiDataSource.getMarvelHeroesList())


}