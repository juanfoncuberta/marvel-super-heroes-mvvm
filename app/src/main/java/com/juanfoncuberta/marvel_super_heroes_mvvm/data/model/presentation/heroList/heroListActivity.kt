package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.juanfoncuberta.marvel_super_heroes_mvvm.R
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import kotlinx.android.synthetic.main.activity_main.*

class heroListActivity : AppCompatActivity() {
    lateinit var heroListViewModel: HeroListViewModel
    private val adapter = HeroListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecycler()
        setUpViewModel()
    }

    private fun setUpRecycler(){
        heroesListRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        heroesListRecycler.itemAnimator = DefaultItemAnimator()
        heroesListRecycler.adapter = adapter
    }

    private  fun setUpViewModel(){
        heroListViewModel = ViewModelProviders.of(this).get(HeroListViewModel::class.java)
        bindEvents()

    }

    private fun bindEvents(){
        heroListViewModel.isLoadingState.observe(this, Observer {
            isLoading ->
            isLoading?.let {
                showLoading(it)
            }
        })
        heroListViewModel.marvelHeroesListState.observe(this,Observer{
            heroList->
            heroList?.let {
                onHeroListLoaded(it)
            }

        })
    }

    private  fun onHeroListLoaded(heroList: List<MarvelHero>){
        adapter.submitList(heroList)
    }

    private  fun showLoading(isLoading: Boolean){
        heroesListLoading.visibility = if(isLoading) View.VISIBLE else View.GONE
    }
}


