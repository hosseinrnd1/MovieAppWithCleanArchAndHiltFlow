package com.example.moviesampleclean.data.movie.model

data class Data(
    val genres: List<String>,
    val id: Int,
    val images: List<String>,
    val poster: String,
    val title: String
)