package com.example.moviesampleclean.data.movie.repository

import android.util.Log
import com.example.moviesampleclean.data.movie.model.Movie
import com.example.moviesampleclean.data.movie.model.factory.MovieFactory
import com.example.moviesampleclean.domain.movie.repository.MovieRepository
import com.example.moviesampleclean.util.Source
import com.example.moviesampleclean.util.exception.MovieExceptionMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import java.lang.Exception
import javax.inject.Inject

private const val TAG = "MovieRepositoryImp"
class MovieRepositoryImp @Inject constructor(private val movieFactory: MovieFactory) : MovieRepository {
    override suspend fun getMovies(): Flow<Movie> {
       return movieFactory.create(Source.LOCAL).getMovies(1)
    }

     override suspend fun syncMovies() {
        movieFactory.create(Source.NETWORK).getMovies(1)
            .catch { exception ->EventBus.getDefault().post(MovieExceptionMapper.map(exception)) }
            .collect{ movies-> movieFactory.create(Source.LOCAL).addMovies(movies) }

    }
}