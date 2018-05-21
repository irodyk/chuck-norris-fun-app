package com.yurets.chucknorrisfunapp.di.module

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.data.repository.JokeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesJokeRepository(): JokeRepositoryBoundary = JokeRepository()
}