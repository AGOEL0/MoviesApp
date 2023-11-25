package com.example.moviesapp.data.presentation.di

import android.app.Activity
import com.example.moviesapp.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MainActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }

}