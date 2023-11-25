package com.example.moviesapp.data.presentation.di

import com.example.moviesapp.data.MovieRepositoryImpl
import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryDataModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
        movieRemoteDataSource: MovieRemoteDataSource

    ): MovieRepository {
        return MovieRepositoryImpl(
            movieLocalDataSource, movieCacheDataSource, movieRemoteDataSource
        )
    }

}