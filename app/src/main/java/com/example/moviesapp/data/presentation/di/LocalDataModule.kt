package com.example.moviesapp.data.presentation.di

import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasourceImpl.MovieLocalDataSourceImpl
import com.example.moviesapp.data.db.MoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MoviesDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

}