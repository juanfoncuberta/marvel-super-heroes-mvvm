package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.db

import android.arch.persistence.room.*
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class HeroDao {
    @Query("SELECT  * FROM MarvelHero")
    abstract fun getAllHeroes(): Maybe<List<MarvelHero>>

    @Query("SELECT * FROM MarvelHero WHERE id = :heroId")
    abstract fun getSuperhero(heroId: String): Maybe<MarvelHero>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertAll(SuperheroesList: List<MarvelHero>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertHero(hero: MarvelHero)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun updateHero(hero: MarvelHero): Int


}