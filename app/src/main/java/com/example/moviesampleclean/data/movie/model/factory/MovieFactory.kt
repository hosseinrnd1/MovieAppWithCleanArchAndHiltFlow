package com.example.moviesampleclean.data.movie.model.factory

import com.example.moviesampleclean.data.movie.source.MovieDataSource
import com.example.moviesampleclean.data.movie.source.local.MovieLocalDataSource
import com.example.moviesampleclean.data.movie.source.remote.MovieRemoteDataSource
import com.example.moviesampleclean.util.Source
import javax.inject.Inject

class MovieFactory @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
    ) {

    fun create(source: Source):MovieDataSource{
        return when(source){
            Source.NETWORK -> movieRemoteDataSource
            else -> movieLocalDataSource
        }
    }
}