package com.example.moviesampleclean.data.database.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    val genres: List<String>,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val images: List<String>,
    val poster: String,
    val title: String)



