package com.example.moviesapp.data.presentation.di

import com.example.moviesapp.data.api.TMBDService
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey:String) {
    @Singleton
    @Provides
    fun provideRemoteDatabase(tmdbService:TMBDService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apikey)
    }
}