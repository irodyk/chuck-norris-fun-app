package com.yurets.chucknorrisfunapp.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.yurets.data.JokeRepositoryBoundary
import com.yurets.data.datasource.local.JokeDao
import com.yurets.data.datasource.local.JokeDatabase
import com.yurets.data.repository.JokeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesJokeDao(database: JokeDatabase) = database.jokeDao()

    @Provides
    @Singleton
    fun providesJokeRepository(jokeDao: JokeDao): JokeRepositoryBoundary = JokeRepository(jokeDao)

    @Provides
    @Singleton
    fun providesJokeDatabase(application: Application) : JokeDatabase =
            Room.databaseBuilder(application.applicationContext, JokeDatabase::class.java, "joke_db")
                .fallbackToDestructiveMigration()
                .build()
}