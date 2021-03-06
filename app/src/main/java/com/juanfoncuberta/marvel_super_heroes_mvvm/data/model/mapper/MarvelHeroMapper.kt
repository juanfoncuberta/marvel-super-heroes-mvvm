package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.mapper

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.Hero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero

class MarvelHeroMapper: Mapper<Hero,MarvelHero> {
    override fun transform(input: Hero): MarvelHero = MarvelHero(
            input.id,
            input.name,
            input.photo,
            input.realName,
            input.height,
            input.power,
            input.abilities,
            input.groups,
            input.favourite)



    override fun transformList(inputList: List<Hero>): List<MarvelHero> =  inputList.map { transform(it) }


}