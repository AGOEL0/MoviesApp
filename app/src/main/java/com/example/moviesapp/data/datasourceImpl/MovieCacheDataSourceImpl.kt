package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl:MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

}