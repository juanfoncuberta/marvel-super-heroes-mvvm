package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "MarvelHero")
@Parcelize
data class MarvelHero(
        @PrimaryKey()
        val id: Long,
        val name: String,
        val photoUrl: String,
        val realName: String,
        val height: String,
        val power: String,
        val abilities: String,
        val groups: String,
        var favourite: Boolean
):Parcelable