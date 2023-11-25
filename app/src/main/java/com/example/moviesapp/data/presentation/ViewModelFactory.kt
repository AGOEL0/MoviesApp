package com.example.moviesapp.data.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.domain.repository.usecases.GetMoviesUseCase
import com.example.moviesapp.domain.repository.usecases.UpdateMoviesUseCase

class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getMoviesUseCase,updateMoviesUseCase) as T
    }
}