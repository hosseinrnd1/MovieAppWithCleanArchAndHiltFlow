package com.example.moviesampleclean.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesampleclean.data.database.MyRoomDataBase
import com.example.moviesampleclean.data.database.movie.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context):MyRoomDataBase{
        return Room.databaseBuilder(context,MyRoomDataBase::class.java,"movie_db").build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(roomDataBase: MyRoomDataBase):MovieDao{
        return roomDataBase.movieDao()
    }

}