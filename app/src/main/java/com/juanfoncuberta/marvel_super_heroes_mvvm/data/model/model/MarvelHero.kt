package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model
import com.google.gson.annotations.SerializedName
data class MarvelHero(
        val name: String = "",
     //   @SerializedName("photo")
        val photoUrl: String = "",
        val realName: String = "",
        val height: String = "",
        val power: String = "",
        val abilities: String = "",
        val groups: String = ""
)