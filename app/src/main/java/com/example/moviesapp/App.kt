package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.data.presentation.di.AppComponent
import com.example.moviesapp.data.presentation.di.AppModule
import com.example.moviesapp.data.presentation.di.DaggerAppComponent
import com.example.moviesapp.data.presentation.di.Injector
import com.example.moviesapp.data.presentation.di.MovieSubComponent
import com.example.moviesapp.data.presentation.di.NetModule
import com.example.moviesapp.data.presentation.di.RemoteDataModule

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}