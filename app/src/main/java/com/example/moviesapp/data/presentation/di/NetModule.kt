package com.example.moviesapp.data.presentation.di

import com.example.moviesapp.data.api.TMBDService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
class NetModule(private val baseUrl:String) {
@Singleton
@Provides
fun provideRetrofit():Retrofit{
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl).build()

}
@Singleton
@Provides
fun providesTMBDServices(retrofit: Retrofit):TMBDService{
    return retrofit.create(TMBDService::class.java)
}

}