package com.example.moviesampleclean.domain.movie.usecase

import com.example.moviesampleclean.data.movie.model.Movie
import com.example.moviesampleclean.domain.movie.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovies @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): Flow<Movie>{
        return movieRepository.getMovies()
    }
}