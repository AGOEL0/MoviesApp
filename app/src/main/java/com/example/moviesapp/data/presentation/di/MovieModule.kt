package com.example.moviesapp.data.presentation.di

import com.example.moviesapp.data.presentation.ViewModelFactory
import com.example.moviesapp.domain.repository.usecases.GetMoviesUseCase
import com.example.moviesapp.domain.repository.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory{

        return ViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }

}