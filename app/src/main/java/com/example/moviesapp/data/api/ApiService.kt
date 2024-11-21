package com.example.moviesapp.data.api

import com.example.moviesapp.data.model.MovieDetail
import com.example.moviesapp.data.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun getMovies(
        @Query("s") searchKey: String,
        @Query("apikey") apiKey: String = "fcb9387b"
    ): Response<MoviesList>

    @GET("/")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = "fcb9387b"
    ): Response<MovieDetail>
}