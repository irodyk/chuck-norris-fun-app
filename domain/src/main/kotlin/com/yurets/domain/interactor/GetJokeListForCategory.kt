package com.yurets.domain.interactor

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.domain.model.Joke
import io.reactivex.Flowable
import javax.inject.Inject

class GetJokeListForCategory @Inject constructor(private val jokeRepository: JokeRepositoryBoundary){

    fun getJokeListForCategory(page: Int, category: String): Flowable<List<Joke>> {
        return jokeRepository.getListForCategory(category).map {
            jokeDataModels -> jokeDataModels.map(Joke.Mapper.jokeMapper)
        }
    }
}