package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.model
import android.os.Parcel
import android.os.Parcelable
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
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(photoUrl)
        parcel.writeString(realName)
        parcel.writeString(height)
        parcel.writeString(power)
        parcel.writeString(abilities)
        parcel.writeString(groups)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MarvelHero> {
        override fun createFromParcel(parcel: Parcel): MarvelHero {
            return MarvelHero(parcel)
        }

        override fun newArray(size: Int): Array<MarvelHero?> {
            return arrayOfNulls(size)
        }
    }
}