package com.yurets.data.datasource.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.yurets.data.datasource.local.entity.JokeEntity

@Database(entities = [(JokeEntity::class)], version = 1)
abstract class JokeDatabase : RoomDatabase() {

    abstract fun jokeDao(): JokeDao
}