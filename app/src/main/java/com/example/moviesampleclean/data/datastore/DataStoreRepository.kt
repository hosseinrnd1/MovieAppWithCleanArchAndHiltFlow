package com.example.moviesampleclean.data.datastore

interface DataStoreRepository {

    suspend fun saveString(key : String ,value : String)

    suspend fun readString(key : String) : String?

    suspend fun saveInt(key : String , value : Int)

    suspend fun readInt(key : String) : Int?
}