package com.example.moviesapp.data.api

import retrofit2.http.Query
import com.example.moviesapp.data.movieList
import retrofit2.Response
import retrofit2.http.GET

interface TMBDService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apikey:String
    ): Response<movieList>
}