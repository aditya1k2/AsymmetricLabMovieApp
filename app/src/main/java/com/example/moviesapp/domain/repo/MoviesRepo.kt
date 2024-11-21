package com.example.moviesapp.domain.repo

import com.example.moviesapp.data.ApiResult
import com.example.moviesapp.data.model.MovieDetail
import com.example.moviesapp.data.model.MoviesList
import kotlinx.coroutines.flow.Flow

interface MoviesRepo {
    suspend fun getMovies(searchKey: String): Flow<ApiResult<MoviesList>>
    suspend fun getMovieDetail(imdbId : String) : Flow<ApiResult<MovieDetail>>
}