package com.example.moviesampleclean.data.movie.api

import com.example.moviesampleclean.data.movie.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/api/v1/movies")
    suspend fun getMovies(@Query("page") page:Int):Movie
}