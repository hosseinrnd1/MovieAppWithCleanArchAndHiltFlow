package com.example.moviesampleclean.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DataStoreRepositoryImp @Inject constructor(val context: Context) : DataStoreRepository {
     private val Context.dataStore:DataStore<Preferences> by preferencesDataStore("userInfo")

    override suspend fun saveString(key: String, value: String) {
        val dataStoreKey= stringPreferencesKey(key)
        context.dataStore.edit { preference ->
        preference[dataStoreKey]=value
        }
    }

    override suspend fun readString(key: String): String? {
        val dataStoreKey= stringPreferencesKey(key)
        val preference=context.dataStore.data.first()
        return preference[dataStoreKey]
    }

    override suspend fun saveInt(key: String, value: Int) {
        val dataStoreKey = intPreferencesKey(key)
        context.dataStore.edit { preference ->
            preference[dataStoreKey] = value
        }
    }

    override suspend fun readInt(key: String): Int? {
        val dataStoreKey = intPreferencesKey(key)
        val preference = context.dataStore.data.first()
        return preference[dataStoreKey]
    }
}