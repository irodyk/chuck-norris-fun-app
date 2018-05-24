package com.yurets.data.datasource.local

import android.arch.persistence.room.*
import com.yurets.data.datasource.local.entity.JokeEntity
import io.reactivex.Flowable

@Dao
interface JokeDao {

    @Query("SELECT COUNT(*) FROM joke")
    fun countJokes() : Int

    @Query("SELECT * FROM joke LIMIT :limit")
    fun queryJokes(limit: Int) : Flowable<List<JokeEntity>>

    @Query("SELECT * FROM joke LIMIT :limit")
    fun queryFavoriteJokes(limit: Int) : Flowable<List<JokeEntity>>

    @Query("SELECT * FROM joke WHERE category= :category LIMIT :limit")
    fun queryJokesForCategory(category: String, limit: Int) : Flowable<List<JokeEntity>>

    @Query("SELECT category FROM joke LIMIT :limit")
    fun queryCategories(limit: Int) : Flowable<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJokes(jokeEntities: List<JokeEntity>) : List<Long>

    @Update
    fun updateJokes(jokeEntities: List<JokeEntity>)
}