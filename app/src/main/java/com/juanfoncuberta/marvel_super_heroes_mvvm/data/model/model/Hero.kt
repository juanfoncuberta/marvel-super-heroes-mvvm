package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model


data class Hero (
    val id: Long,
    val name: String,
    val photo: String,
    val realName: String = "",
    val height: String = "",
    val power: String = "",
    val abilities: String = "",
    val groups: String = "",
    val favourite: Boolean,
    val rating: Int,
    var review: String
)
