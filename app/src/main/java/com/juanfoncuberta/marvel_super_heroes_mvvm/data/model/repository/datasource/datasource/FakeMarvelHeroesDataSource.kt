package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Observable

class FakeMarvelHeroesDataSource: MarvelHeroesDataSource {



    override fun getMarvelHeroesList(): Observable<List<MarvelHero>> {
        return Observable.just(
                arrayListOf(
                        MarvelHero("Black panter", "http://s3-eu-west-1.amazonaws.com/cinemania-cdn/wp-content/uploads/2018/04/25114903/Black-Panther-Wakanda-Civil-War-660x374.jpg"),
                        MarvelHero("Green arrow", "http://nerdrepository.com/wp-content/uploads/2013/09/Review-Arrow-S1-Review-04.jpg")
                )
        )

    }
}