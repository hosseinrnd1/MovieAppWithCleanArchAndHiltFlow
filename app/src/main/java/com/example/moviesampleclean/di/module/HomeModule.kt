package com.example.moviesampleclean.di.module

import com.bumptech.glide.RequestManager
import com.example.moviesampleclean.presentation.home.MovieAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object HomeModule {

    @Provides
    fun provideMovieAdapter(glide:RequestManager):MovieAdapter{
        return MovieAdapter(glide)
    }
}