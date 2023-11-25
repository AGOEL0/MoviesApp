package com.example.moviesapp.data

import com.google.gson.annotations.SerializedName

data class movieList(
    @SerializedName("results")
    val movies: List<Movie>

)
