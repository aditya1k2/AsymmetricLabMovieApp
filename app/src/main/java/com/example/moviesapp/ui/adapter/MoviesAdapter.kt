package com.example.moviesapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.data.model.MovieData
import com.example.moviesapp.data.model.MoviesList
import com.example.moviesapp.databinding.ItemMovieBinding

class MoviesAdapter(
    private val context: Context,
    private val list: ArrayList<MovieData>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = list[position]
        holder.bind(movie)
        holder.binding.root.setOnClickListener {
            onItemClick(movie.imdbID)
        }
    }

    override fun getItemCount(): Int = list.size

    fun addData(movieList: ArrayList<MovieData>) {
        this.list.clear()
        this.list.addAll(movieList)
        notifyDataSetChanged()
    }

    class MoviesViewHolder(val binding: ItemMovieBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieData) {
            binding.movieTitle.text = item.title
            binding.movieYear.text = item.year
            Glide
                .with(context)
                .load(item.poster)
                .centerCrop()
                .into(binding.moviesIv)
        }
    }
}

