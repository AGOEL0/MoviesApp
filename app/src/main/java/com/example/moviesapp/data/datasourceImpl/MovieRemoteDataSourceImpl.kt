package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.api.TMBDService
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.movieList
import retrofit2.Response

class MovieRemoteDataSourceImpl (
    private val tmbdService:TMBDService,
    private val apikey:String
):MovieRemoteDataSource{
    override suspend fun getMovies(): Response<movieList> =
        tmbdService.getPopularMovies(apikey)

}