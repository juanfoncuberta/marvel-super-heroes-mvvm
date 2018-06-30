package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm

import android.app.Activity
import android.content.Intent
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.heroDetail.HeroDetailActivity

object Navigator {

    fun openHeroDetail(activity: Activity,heroName:String){
        val intent = Intent(activity, HeroDetailActivity::class.java)

        intent.putExtra(HeroDetailActivity.PARAM_HERO_ID, heroName)
        activity.startActivity(intent)
    }
}