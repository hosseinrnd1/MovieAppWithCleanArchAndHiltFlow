package com.example.moviesampleclean.data.movie.source

import com.example.moviesampleclean.data.movie.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {
    suspend fun getMovies(page:Int): Flow<Movie>
    suspend fun addMovies(movies: Movie)
}