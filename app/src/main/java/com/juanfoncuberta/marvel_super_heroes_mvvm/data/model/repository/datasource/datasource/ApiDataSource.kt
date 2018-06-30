package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource

import android.util.Log
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.mapper.MarvelHeroMapper
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.net.HeroService
import io.reactivex.Flowable

class ApiDataSource(private  val heroService: HeroService,
                    private val marvelHeroMapper: MarvelHeroMapper): MarvelHeroesDataSource {
    override fun getMarvelHeroesList(): Flowable<List<MarvelHero>> {
        return heroService.getHeroes()
                .map { it.superheroes }
                .map { marvelHeroMapper.transformList(it) }
    }
}