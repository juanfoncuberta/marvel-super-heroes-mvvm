package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Flowable
import io.reactivex.Observable

class FakeMarvelHeroesDataSource: MarvelHeroesDataSource {

    val heroList = null
           /* listOf(
            MarvelHero("Black panter", "http://s3-eu-west-1.amazonaws.com/cinemania-cdn/wp-content/uploads/2018/04/25114903/Black-Panther-Wakanda-Civil-War-660x374.jpg"),
            MarvelHero("Green arrow", "http://nerdrepository.com/wp-content/uploads/2013/09/Review-Arrow-S1-Review-04.jpg"),
            MarvelHero("Iron man", "https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2018/05/traje-iron-man.jpg?itok=Pvirjf3M"),
            MarvelHero("Captain America", "https://pmcvariety.files.wordpress.com/2017/07/captain-america-4th-of-july.jpg?w=1000&h=563&crop=1"),
            MarvelHero("Captain Marvel", "https://cdn.movieweb.com/img.news.tops/NExgROE8paLIBy_1_b/Captain-Marvel-Movie-Concept-Art-Nick-Fury-Costumes.jpg"),
            MarvelHero("Black Widow","https://www.canalfreak.net/wp-content/uploads/2018/04/black-widow-1073631-1280x0-1280x640.jpeg")

    )*/

   /* override fun getMarvelHeroDetail(heroName: String): Observable<MarvelHero> {
        val hero = heroList.find { it.name == heroName }
        return  if(hero != null){
            Observable.just(hero)
        }else{
            Observable.empty()
        }
    }*/


    override fun getMarvelHeroesList(): Flowable<List<MarvelHero>>  =   Flowable.just(heroList)


}