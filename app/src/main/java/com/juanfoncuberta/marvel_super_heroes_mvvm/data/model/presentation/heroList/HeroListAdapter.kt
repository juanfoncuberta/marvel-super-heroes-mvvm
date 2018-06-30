package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList


import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.juanfoncuberta.marvel_super_heroes_mvvm.R

import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHeroDiff
import kotlinx.android.synthetic.main.item_hero.view.*

typealias  onUserClick = (marvelHero: MarvelHero)-> Unit
class HeroListAdapter(val onUserClick: onUserClick):  RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder>(){

    private val items: MutableList<MarvelHero> = mutableListOf()
    override fun getItemCount(): Int = items.size
    fun submitList(items: List<MarvelHero>){
        this.items.addAll(items)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero,parent,false)
        return HeroListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroListViewHolder, position: Int) {
        holder.bind(items[position])
    }


    inner class HeroListViewHolder(view:View): RecyclerView.ViewHolder(view){

        fun bind(marvelHero: MarvelHero){
            with(itemView){
                heroTitle.text = marvelHero.name
                Glide.with(heroImage)
                        .load(marvelHero.photoUrl)
                        .into(heroImage)
            }

            itemView.setOnClickListener {

                    onUserClick(marvelHero)
            }
        }

    }

   /*     fun loadColorsFromBitmap(bitmap: Bitmap) {
            with(itemView) {
                Palette.from(bitmap).generate { palette ->
                    val vibrant = palette.vibrantSwatch
                    vibrant?.let {
                        heroTitle.setBackgroundColor(vibrant.rgb)
                        heroTitle.setTextColor(vibrant.bodyTextColor)
                    }
                }
            }
        }*/


}


