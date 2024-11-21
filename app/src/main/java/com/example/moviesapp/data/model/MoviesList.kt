package com.example.moviesapp.data.model

import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("Search")
    val movieList: ArrayList<MovieData>,
)
