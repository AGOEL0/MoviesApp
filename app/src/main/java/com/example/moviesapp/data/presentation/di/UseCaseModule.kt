package com.example.moviesapp.data.presentation.di

import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.repository.usecases.GetMoviesUseCase
import com.example.moviesapp.domain.repository.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
@Provides
fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
    return GetMoviesUseCase(movieRepository)
}

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

}