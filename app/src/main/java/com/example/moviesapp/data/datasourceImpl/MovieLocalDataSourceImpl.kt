package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.db.MoviesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao:MoviesDao):MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch {
           movieDao.saveMovies(movies)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}