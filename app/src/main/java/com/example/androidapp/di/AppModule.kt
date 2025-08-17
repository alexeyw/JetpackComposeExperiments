package com.example.androidapp.di

import com.example.androidapp.data.ImageRepositoryImpl
import com.example.androidapp.domain.repository.ImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindRepository(impl: ImageRepositoryImpl): ImageRepository
}