package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList



import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.juanfoncuberta.marvel_super_heroes_mvvm.R
import com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model.MarvelHero
import kotlinx.android.synthetic.main.item_hero.view.*

typealias  onUserClick = (marvelHero: MarvelHero)-> Unit
typealias favouriteClick = (marvelHero:MarvelHero)->Unit

class HeroListAdapter(val onUserClick: onUserClick,val favouriteClick: favouriteClick):  RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder>(){

    private val items: MutableList<MarvelHero> = mutableListOf()
    override fun getItemCount(): Int = items.size

    fun submitList(items: List<MarvelHero>){
       this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero,parent,false)
        return HeroListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroListViewHolder, position: Int) = holder.bind(items[position])

    inner class HeroListViewHolder(view:View): RecyclerView.ViewHolder(view){

        fun bind(marvelHero: MarvelHero) =

            with(itemView){
                kotlin.with(itemView){

                heroTitle.text = marvelHero.name
              heroFavouriteIcon.setImageResource(favouriteIcon(marvelHero.favourite))
               heroFavouriteIcon.setOnClickListener { favouriteClick(changeFavouriteState(marvelHero)) }
                Glide.with(heroImage)
                        .load(marvelHero.photoUrl)
                        .into(heroImage)

            }

            itemView.setOnClickListener {

                    onUserClick(marvelHero)
            }
        }

        private fun favouriteIcon(favourite:Boolean):Int{
            if(favourite){
                return R.drawable.favorite_full
            }
            return R.drawable.favorite_empty
        }
        private fun changeFavouriteState(hero: MarvelHero): MarvelHero {
            hero.favourite = !hero.favourite
            return hero
        }
    }

}


