package com.example.moviesapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.Movie


@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie:List<Movie>)
    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()
    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies():List<Movie>
}