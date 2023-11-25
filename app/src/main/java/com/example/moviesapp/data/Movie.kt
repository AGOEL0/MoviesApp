package com.example.moviesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movies")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val Movie_id:Int,
    val title:String,
    val overview:String,
    @SerializedName("poster_path")
    val PosterPath:String,
    @SerializedName("release_date")
    val releaseDate: String
)
