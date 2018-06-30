package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.db.HeroDatabase
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Flowable

class LocalDataSource(val heroDatabase: HeroDatabase): MarvelHeroesDataSource {
    override fun getMarvelHeroesList(): Flowable<List<MarvelHero>> =
        heroDatabase
                .getHeroDao()
                .getAllHeroes()
                .toFlowable()



}