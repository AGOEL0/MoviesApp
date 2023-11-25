package com.example.moviesapp.data.presentation.di

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}