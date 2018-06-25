package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Observable

class FakeMarvelHeroesDataSource: MarvelHeroesDataSource {



    override fun getMarvelHeroesList(): Observable<List<MarvelHero>> {
        return Observable.just(
                arrayListOf(
                        MarvelHero("Black panter", "https://i.blogs.es/30cb7a/blackpanther5/450_1000.jpg"),
                        MarvelHero("Green arrow", "https://thefreakchoice.com/2833-home_default/cojin-arrow-flechas-verde-.jpg")
                )
        )

    }
}