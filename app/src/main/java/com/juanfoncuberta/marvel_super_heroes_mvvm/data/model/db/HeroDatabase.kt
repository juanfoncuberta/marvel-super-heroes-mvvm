package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero

@Database(entities = [MarvelHero::class],version = 1)
abstract class HeroDatabase: RoomDatabase() {

    abstract fun  getHeroDao(): HeroDao

    }