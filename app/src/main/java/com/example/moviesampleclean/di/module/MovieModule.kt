package com.example.moviesampleclean.di.module

import com.example.moviesampleclean.data.movie.repository.MovieRepositoryImp
import com.example.moviesampleclean.domain.movie.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieModule {

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImp: MovieRepositoryImp):MovieRepository
}