package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.serviceLocator

import android.arch.persistence.room.Room
import android.content.Context
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.db.HeroDatabase
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.mapper.MarvelHeroMapper
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.Hero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.net.HeroService
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm.SettingsManager
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.MarvelHeroesRepository
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.ApiDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.FakeMarvelHeroesDataSource
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.repository.datasource.datasource.LocalDataSource
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Inject {
    lateinit var database: HeroDatabase
    val retrofit = Retrofit.Builder()
            .baseUrl("https://api.myjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    val marvelHeroMapper = MarvelHeroMapper()
    val heroService = retrofit.create(HeroService::class.java)
    lateinit var  settingsManager: SettingsManager
    val fakeMarvelHeroesDataSource = FakeMarvelHeroesDataSource()
    val apiDataSource = ApiDataSource(heroService,marvelHeroMapper)
    lateinit var localDataSource: LocalDataSource
    lateinit var marvelHeroesRepository:  MarvelHeroesRepository

    fun initDatabase(context: Context){

        database = Room.databaseBuilder(context,HeroDatabase::class.java,"hero.db").build()
        localDataSource = LocalDataSource(database)
        marvelHeroesRepository = MarvelHeroesRepository(apiDataSource, localDataSource)
    }

}