package com.example.moviesapp.data.model


import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("Plot")
    val plot: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Poster")
    val poster: String
)