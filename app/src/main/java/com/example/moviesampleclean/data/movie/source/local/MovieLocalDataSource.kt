package com.example.moviesampleclean.data.movie.source.local

import com.example.moviesampleclean.data.database.movie.dao.MovieDao
import com.example.moviesampleclean.data.movie.mapper.MovieEntityMapper.toEntityMovies
import com.example.moviesampleclean.data.movie.mapper.MovieEntityMapper.toMovies
import com.example.moviesampleclean.data.movie.model.Movie
import com.example.moviesampleclean.data.movie.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) : MovieDataSource {
    override suspend fun getMovies(page:Int): Flow<Movie> {
        return movieDao.getMovies().toMovies()
    }

    override suspend fun addMovies(movies: Movie) {
        return movieDao.insertMovies(movies.toEntityMovies())
    }
}