package com.example.moviesapp.data.presentation.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.data.db.MoviesDao
import com.example.moviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun providesDatabase(context:Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient").build()
    }
    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MoviesDao{
        return tmdbDatabase.movieDao()
    }
}