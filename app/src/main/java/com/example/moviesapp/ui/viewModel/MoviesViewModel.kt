package com.example.moviesapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.ApiResult
import com.example.moviesapp.data.model.MovieData
import com.example.moviesapp.data.model.MovieDetail
import com.example.moviesapp.data.model.MoviesList
import com.example.moviesapp.domain.repo.MoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesRepo: MoviesRepo) : ViewModel() {

    private val _moviesList: MutableStateFlow<ApiResult<MoviesList>> =
        MutableStateFlow(ApiResult.Default)
    val moviesList = _moviesList.asStateFlow()

    fun getMoviesList(searchKey: String) {
        viewModelScope.launch {
            moviesRepo.getMovies(searchKey).collect {
                _moviesList.value = it
            }
        }
    }

    private val _movieDetail: MutableStateFlow<ApiResult<MovieDetail>> = MutableStateFlow(ApiResult.Default)
    val movieDetail = _movieDetail.asStateFlow()

    fun getMovieDetail(imdbId: String) {
        viewModelScope.launch {
            moviesRepo.getMovieDetail(imdbId = imdbId).collect {
                _movieDetail.value = it
            }
        }
    }
}