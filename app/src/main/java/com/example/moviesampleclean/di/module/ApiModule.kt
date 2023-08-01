package com.example.moviesampleclean.di.module

import com.example.moviesampleclean.data.movie.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {


    @Provides
    @Singleton
    fun provideMovieApi(retrofit:Retrofit):MovieApi{
        return retrofit.create(MovieApi::class.java)
    }

}