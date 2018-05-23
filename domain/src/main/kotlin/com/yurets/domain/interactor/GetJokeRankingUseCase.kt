package com.yurets.domain.interactor

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.domain.model.Joke
import io.reactivex.Flowable
import javax.inject.Inject

class GetJokeRankingUseCase @Inject constructor(private val jokeRepository: JokeRepositoryBoundary){

    fun getJokeRanking(page: Int): Flowable<List<Joke>> {

        return jokeRepository.getAllJokesList().map { jokeDataModels ->
            jokeDataModels.map(Joke.Mapper.jokeMapper)
        }
    }
}