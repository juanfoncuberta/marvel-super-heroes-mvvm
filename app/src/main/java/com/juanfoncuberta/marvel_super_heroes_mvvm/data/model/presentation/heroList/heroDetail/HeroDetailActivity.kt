package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.heroDetail

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import com.juanfoncuberta.marvel_super_heroes_mvvm.R
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import kotlinx.android.synthetic.main.activity_hero_detail.*

class HeroDetailActivity: AppCompatActivity(){


    companion object {
        const val PARAM_HERO_ID = "hero_id"
    }
    lateinit var heroDetailViewModel: HeroDetailViewModel
    lateinit var marvelHero: MarvelHero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)

        marvelHero = intent.getParcelableExtra(PARAM_HERO_ID)
        init()
    }

    private fun init(){
        heroDetailViewModel = ViewModelProviders.of(this).get(HeroDetailViewModel::class.java)
       // bindEvents()
        loadHeroData()
    }

    private  fun loadHeroData(){

        marvelHero?.let {
            onHeroLoaded(marvelHero)
            return
        }
        setResult(Activity.RESULT_CANCELED)
        finish()

    }

/*    private fun bindEvents(){
        heroDetailViewModel.heroState.observe(this, Observer {
            it?.let {
                onHeroLoaded(it)
            }
        })
    }*/
    private  fun onHeroLoaded(marvelHero: MarvelHero){
        Log.d("HeroDetailActivity",marvelHero.name)
        heroDetailName.text = marvelHero.name
        Glide.with(this)
                .load(marvelHero.photoUrl)
                .into(heroDetailImage)
    }
}