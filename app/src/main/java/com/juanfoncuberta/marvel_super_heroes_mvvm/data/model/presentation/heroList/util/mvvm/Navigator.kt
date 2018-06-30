package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm

import android.app.Activity
import android.content.Intent
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.heroDetail.HeroDetailActivity

object Navigator {
//    fun openHeroDetail(activity: Activity,heroName:String){
    fun openHeroDetail(activity: Activity,marvelHero:MarvelHero){
        val intent = Intent(activity, HeroDetailActivity::class.java)

        intent.putExtra(HeroDetailActivity.PARAM_HERO_ID, marvelHero)
        activity.startActivity(intent)
    }
}