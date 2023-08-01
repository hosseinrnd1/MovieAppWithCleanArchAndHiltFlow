package com.example.moviesampleclean.data.database.movie.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesampleclean.data.database.movie.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies:List<MovieEntity>)

    @Query("SELECT * FROM movie")
    fun getMovies(): Flow<List<MovieEntity>>
}