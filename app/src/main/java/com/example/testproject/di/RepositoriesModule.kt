package com.example.testproject.di

import com.example.data.repositories.ApiRepositoryImpl
import com.example.domain.repositories.ApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindsProvideRepository(repositoryImpl: ApiRepositoryImpl): ApiRepository
}