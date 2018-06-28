package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model

import android.support.v7.util.DiffUtil

class MarvelHeroDiff: DiffUtil.ItemCallback<MarvelHero>() {
    override fun areItemsTheSame(oldItem: MarvelHero?, newItem: MarvelHero?): Boolean  = oldItem?.name == newItem?.name

    override fun areContentsTheSame(oldItem: MarvelHero?, newItem: MarvelHero?): Boolean = newItem == oldItem
}