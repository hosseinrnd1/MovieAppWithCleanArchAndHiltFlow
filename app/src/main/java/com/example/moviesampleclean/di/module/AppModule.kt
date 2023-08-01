package com.example.moviesampleclean.di.module

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.moviesampleclean.data.datastore.DataStoreRepository
import com.example.moviesampleclean.data.datastore.DataStoreRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGlide(@ApplicationContext context: Context):RequestManager{
        return Glide.with(context)
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context : Context): DataStoreRepository {
        return DataStoreRepositoryImp(context)
    }
}