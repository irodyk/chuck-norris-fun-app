package com.yurets.data;

import com.yurets.data.model.JokeDataModel
import io.reactivex.Flowable
import io.reactivex.Maybe

interface JokeRepositoryBoundary {

    fun getAllJokesList() : Flowable<List<JokeDataModel>>
    fun getFavoriteList() : Flowable<List<JokeDataModel>>
    fun getRatingList() : Flowable<List<JokeDataModel>>
    fun getCategoryList() : Flowable<List<String>>
    fun getListForCategory(category : String) : Flowable<List<JokeDataModel>>
    fun prePopulateDb(jokeList: List<JokeDataModel>) : Maybe<Int>
    fun jokesCount() : Int
}
