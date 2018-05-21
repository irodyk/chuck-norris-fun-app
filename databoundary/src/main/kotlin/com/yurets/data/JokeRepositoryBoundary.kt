package com.yurets.data;

import com.yurets.data.model.CategoryDataModel
import com.yurets.data.model.JokeDataModel
import io.reactivex.Observable

interface JokeRepositoryBoundary {

    fun getAllJokesList() : Observable<MutableList<JokeDataModel>>
    fun getFavoriteList() : Observable<MutableList<JokeDataModel>>
    fun getRatingList() : Observable<MutableList<JokeDataModel>>
    fun getCategoryList() : Observable<MutableList<CategoryDataModel>>
    fun getListForCategory(category : CategoryDataModel) : Observable<MutableList<JokeDataModel>>
}
