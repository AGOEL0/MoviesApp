package com.example.moviesapp.data.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
     NetModule::class,
     RemoteDataModule::class,
      UseCaseModule::class,
      RepositoryDataModule::class
       ])

interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
}