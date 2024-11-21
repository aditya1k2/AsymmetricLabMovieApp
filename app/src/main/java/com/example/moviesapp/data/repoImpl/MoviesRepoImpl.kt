package com.example.moviesapp.data.repoImpl

import com.example.moviesapp.data.ApiResult
import com.example.moviesapp.data.NetworkUtils
import com.example.moviesapp.data.api.ApiService
import com.example.moviesapp.data.model.MovieDetail
import com.example.moviesapp.data.model.MoviesList
import com.example.moviesapp.domain.repo.MoviesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepoImpl @Inject constructor(private val apiService: ApiService) : MoviesRepo {
    override suspend fun getMovies(searchKey: String): Flow<ApiResult<MoviesList>> {
        return NetworkUtils.toResultFlow {
            apiService.getMovies(searchKey = searchKey)
        }
    }

    override suspend fun getMovieDetail(imdbId: String): Flow<ApiResult<MovieDetail>> {
        return NetworkUtils.toResultFlow {
            apiService.getMovieDetail(imdbId = imdbId)
        }
    }
}