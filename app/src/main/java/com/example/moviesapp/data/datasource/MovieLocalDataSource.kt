package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)

    suspend fun clearAll()
}