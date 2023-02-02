package com.example.acronymresolver.di

import com.example.acronymresolver.repository.NetworkCall
import com.example.acronymresolver.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(
    ) : Retrofit {
       return Retrofit.Builder()
            .baseUrl(Repository.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideNetworkCall(retrofit: Retrofit): NetworkCall {
     return retrofit.create(NetworkCall::class.java)
    }
}