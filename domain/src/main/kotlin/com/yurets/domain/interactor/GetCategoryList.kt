package com.yurets.domain.interactor

import com.yurets.data.JokeRepositoryBoundary
import io.reactivex.Flowable
import javax.inject.Inject

class GetCategoryList @Inject constructor(private val jokeRepository: JokeRepositoryBoundary){

    fun getCategoryList(): Flowable<List<String>> {
        return jokeRepository.getCategoryList()
    }
}