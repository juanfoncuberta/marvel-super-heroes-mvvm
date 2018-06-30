package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class HeroDao {
    @Query("SELECT  * FROM MarvelHero")
    abstract fun getAllHeroes(): Maybe<List<MarvelHero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  fun insertAll(heroes: List<MarvelHero>)

    //TODO REPLACE
}