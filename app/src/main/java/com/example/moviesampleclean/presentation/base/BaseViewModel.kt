package com.example.moviesampleclean.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel(){
    val progressLiveData= MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()
    }

}