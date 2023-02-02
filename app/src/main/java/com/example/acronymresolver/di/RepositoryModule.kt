package com.example.acronymresolver.di

import com.example.acronymresolver.repository.NetworkCall
import com.example.acronymresolver.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(networkCall: NetworkCall) : Repository {
        return Repository(networkCall)
    }




}