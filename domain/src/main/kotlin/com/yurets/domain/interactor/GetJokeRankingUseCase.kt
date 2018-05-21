package com.yurets.domain.interactor

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.data.model.JokeDataModel
import com.yurets.domain.model.Joke
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetJokeRankingUseCase @Inject constructor(private val jokeRepository: JokeRepositoryBoundary){

    fun getJokeRanking(page: Int): Observable<List<Joke>> {

        return jokeRepository.getAllJokesList().map { jokeDataModels ->
            jokeDataModels.map(Joke.Mapper.jokeMapper)
        }
    }
}