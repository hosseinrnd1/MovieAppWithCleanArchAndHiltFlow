package com.example.moviesampleclean.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviesampleclean.data.database.movie.dao.MovieDao
import com.example.moviesampleclean.data.database.movie.model.MovieEntity

@Database(entities = [MovieEntity::class],version=1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class MyRoomDataBase : RoomDatabase() {

    abstract fun movieDao():MovieDao
}