package com.example.moviesapp.data.presentation.di

import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }
}