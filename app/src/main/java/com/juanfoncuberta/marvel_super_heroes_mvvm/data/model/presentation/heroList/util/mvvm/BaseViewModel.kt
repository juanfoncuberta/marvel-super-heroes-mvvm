package com.juanfoncuberta.marvel_super_heroes_mvvm.data.model.presentation.heroList.util.mvvm

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel:ViewModel() {

 internal val compositeDisposable =  CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}