package com.yurets.data.repository

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.data.model.CategoryDataModel
import com.yurets.data.model.JokeDataModel
import io.reactivex.Observable

class JokeRepository : JokeRepositoryBoundary {

    private val categoryList : MutableList<CategoryDataModel> = mutableListOf(
            CategoryDataModel(1, "Category 1"),
            CategoryDataModel(2, "Category 2"),
            CategoryDataModel(3, "Category 3"),
            CategoryDataModel(4, "Category 4"),
            CategoryDataModel(5, "Category 5"),
            CategoryDataModel(6, "Category 6"),
            CategoryDataModel(6, "Category 7"),
            CategoryDataModel(6, "Category 8"),
            CategoryDataModel(6, "Category 9"),
            CategoryDataModel(6, "Category 10")
    )

    private val jokeList : MutableList<JokeDataModel> = mutableListOf(
        JokeDataModel(1, "joke 1", 4, 4.7f),
        JokeDataModel(2, "joke 2", 4, 4.23f),
        JokeDataModel(3, "joke 3", 4, 4f),
        JokeDataModel(4, "joke 4", 4, 3.22f),
        JokeDataModel(5, "joke 5", 4, 4f),
        JokeDataModel(6, "joke 6", 4, 4.01f),
        JokeDataModel(9, "joke 9", 4, 4f),
        JokeDataModel(12, "joke 12", 4, 4f),
        JokeDataModel(13, "joke 13", 4, 4f),
        JokeDataModel(15, "joke 15", 4, 1.9f),
        JokeDataModel(22, "joke 22", 4, 4f)
    )

    override fun getAllJokesList(): Observable<MutableList<JokeDataModel>> {
        return Observable.just(jokeList)
    }

    override fun getFavoriteList(): Observable<MutableList<JokeDataModel>> {
        return Observable.just(jokeList)
    }

    override fun getRatingList(): Observable<MutableList<JokeDataModel>> {
        return Observable.just(jokeList)
    }

    override fun getCategoryList(): Observable<MutableList<CategoryDataModel>> {
        return Observable.just(categoryList)
    }

    override fun getListForCategory(category: CategoryDataModel): Observable<MutableList<JokeDataModel>> {
        return Observable.just(jokeList)
    }

}