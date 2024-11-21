package com.example.moviesapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.ApiResult
import com.example.moviesapp.data.model.MovieDetail
import com.example.moviesapp.databinding.ActivityMovieDetailBinding
import com.example.moviesapp.databinding.ItemMovieBinding
import com.example.moviesapp.ui.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private val mViewModel: MoviesViewModel by viewModels()
    private lateinit var mBinding: ActivityMovieDetailBinding
    private lateinit var imdbId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        intent.getStringExtra("imdbID")?.let { mViewModel.getMovieDetail(it) }
        collectData()
    }


    private fun initViews(movieDetail: MovieDetail) {

        Glide
            .with(this)
            .load(movieDetail.poster)
            .centerCrop()
            .into(mBinding.posterIv)

        mBinding.movieDetail.text = movieDetail.plot
    }

    private fun collectData() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mViewModel.movieDetail.collect {
                    when (it) {
                        is ApiResult.Default -> {
                        }

                        is ApiResult.Error -> {
                            mBinding.progressBar.visibility = View.GONE
                        }

                        is ApiResult.Loading -> {
                            mBinding.progressBar.visibility = View.VISIBLE
                        }

                        is ApiResult.Success -> {
                            mBinding.progressBar.visibility = View.GONE
                            it.data?.let { it1 -> initViews(it1) }
                        }
                    }
                }
            }
        }
    }
}