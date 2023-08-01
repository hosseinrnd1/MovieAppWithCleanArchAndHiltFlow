package com.example.moviesampleclean.data.movie.source.remote

import com.example.moviesampleclean.data.movie.api.MovieApi
import com.example.moviesampleclean.data.movie.model.Movie
import com.example.moviesampleclean.data.movie.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val movieApi: MovieApi) : MovieDataSource{
    override suspend fun getMovies(page : Int): Flow<Movie> {
        return flow {
            emit(movieApi.getMovies(page))
        }
    }

    override suspend fun addMovies(movies: Movie) {
        TODO("Not yet implemented")
    }

}