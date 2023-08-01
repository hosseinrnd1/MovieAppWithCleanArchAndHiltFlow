package com.example.moviesampleclean.presentation.profile

import com.example.moviesampleclean.data.datastore.DataStoreRepository
import com.example.moviesampleclean.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val dataStoreRepository: DataStoreRepository) : BaseViewModel() {

    suspend fun saveUserName(userName: String,password:String) {
        dataStoreRepository.saveString(userName, password)
    }

    suspend fun getUserName(userName: String):String?{
        return dataStoreRepository.readString(userName)
    }

}