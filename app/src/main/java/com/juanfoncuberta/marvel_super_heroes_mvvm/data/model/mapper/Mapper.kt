package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.mapper

interface Mapper<in R, out T> {

    fun transform(input: R): T
    fun transformList(inputList: List<R>): List<T>

}