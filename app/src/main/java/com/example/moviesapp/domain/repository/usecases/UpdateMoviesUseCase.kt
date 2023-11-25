package com.example.moviesapp.domain.repository.usecases

import com.example.moviesapp.data.Movie
import com.example.moviesapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}