package com.example.moviesapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.data.ApiResult
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.ui.adapter.MoviesAdapter
import com.example.moviesapp.ui.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MoviesAdapter
    private val mViewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViews()
        collectData()
    }

    private fun collectData() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mViewModel.moviesList.collect {
                    when (it) {
                        is ApiResult.Error -> {
                            mBinding.progressBar.visibility = View.GONE
                        }

                        is ApiResult.Loading -> {
                            mBinding.progressBar.visibility = View.VISIBLE
                        }

                        is ApiResult.Success -> {
                            mBinding.progressBar.visibility = View.GONE
                            mAdapter.addData(it.data?.movieList ?: arrayListOf())
                        }

                        ApiResult.Default -> {

                        }
                    }
                }
            }
        }
    }

    private fun initViews() {
        mBinding.moviesRV.layoutManager = LinearLayoutManager(this)
        mAdapter = MoviesAdapter(this, arrayListOf()) {
            Log.d("####", it)
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("imdbID", it)
            startActivity(intent)
        }
        mBinding.moviesRV.adapter = mAdapter

        mBinding.searchBtn.setOnClickListener {
            if (mBinding.searchET.text.toString().length >= 2) {
                mViewModel.getMoviesList(mBinding.searchET.text.toString().trim())
            }
        }

    }


}