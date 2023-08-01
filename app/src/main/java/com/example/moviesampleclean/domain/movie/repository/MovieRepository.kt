package com.example.moviesampleclean.domain.movie.repository

import com.example.moviesampleclean.data.movie.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(): Flow<Movie>
    suspend fun syncMovies()

}