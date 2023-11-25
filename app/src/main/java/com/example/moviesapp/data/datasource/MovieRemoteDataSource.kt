package com.example.moviesapp.data.datasource
import com.example.moviesapp.data.movieList
import retrofit2.Response


interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<movieList>

}