package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.db

import android.arch.persistence.room.*
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class HeroDao {
    @Query("SELECT  * FROM MarvelHero")
    abstract fun getAllHeroes(): Maybe<List<MarvelHero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  fun insertAll(heroes: List<MarvelHero>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertHero(hero: MarvelHero)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun updateHero(hero: MarvelHero): Int


}