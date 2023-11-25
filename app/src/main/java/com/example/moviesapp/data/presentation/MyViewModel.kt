package com.example.moviesapp.data.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.repository.usecases.GetMoviesUseCase
import com.example.moviesapp.domain.repository.usecases.UpdateMoviesUseCase

class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) :ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)

    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}