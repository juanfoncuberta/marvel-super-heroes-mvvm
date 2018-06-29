package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.serviceLocator

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.MarvelHeroesRepository
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource2

object Inject {

     val fakeMarvelHeroesDataSource = FakeMarvelHeroesDataSource()
    val fakeMarvelHeroesDataSource2 = FakeMarvelHeroesDataSource2()
     val marvelHeroesRepository =  MarvelHeroesRepository(fakeMarvelHeroesDataSource, fakeMarvelHeroesDataSource2)

}