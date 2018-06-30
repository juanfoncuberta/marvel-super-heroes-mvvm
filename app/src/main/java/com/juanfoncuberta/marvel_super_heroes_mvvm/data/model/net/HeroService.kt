package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.net

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHeroApiResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface HeroService {

    @GET("bins/bvyob/")
    fun getHeroes():Flowable<MarvelHeroApiResponse>
}