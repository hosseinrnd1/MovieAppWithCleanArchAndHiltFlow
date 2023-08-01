package com.example.moviesampleclean.data.movie.mapper

import com.example.moviesampleclean.data.database.movie.model.MovieEntity
import com.example.moviesampleclean.data.movie.model.Data
import com.example.moviesampleclean.data.movie.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty

object MovieEntityMapper {

    fun Flow<List<MovieEntity>>.toMovies(): Flow<Movie> {

         return map { movieEntities ->

                val data=movieEntities.map { movieEntity ->
                    Data(
                        movieEntity.genres,
                        movieEntity.id,
                        movieEntity.images,
                        movieEntity.poster,
                        movieEntity.title
                    )
                }
                Movie(data)
            }

    }



    fun Movie.toEntityMovies(): List<MovieEntity> {
        val movieEntities = ArrayList<MovieEntity>()

        for (i in 0 until this.data.size) {
            movieEntities.add(
                MovieEntity(
                    this.data[i].genres,
                    this.data[i].id,
                    this.data[i].images,
                    this.data[i].poster,
                    this.data[i].title
                )
            )
        }

        return movieEntities
    }

}
