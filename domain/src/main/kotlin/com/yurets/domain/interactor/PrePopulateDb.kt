package com.yurets.domain.interactor

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.data.model.JokeDataModel
import io.reactivex.Maybe
import javax.inject.Inject

class PrePopulateDb @Inject constructor(private val jokeRepository: JokeRepositoryBoundary){

    fun prePopulateDb() : Maybe<Int> {
        return Maybe.fromCallable {
            val recordsCount = jokeRepository.jokesCount()
            if(recordsCount > 0) recordsCount else jokeRepository.prePopulateDb(jokeList).blockingGet()
        }
    }

    private val jokeList : List<JokeDataModel> = mutableListOf(
            JokeDataModel(1,"Category 1",  "joke 1", 4, 4.7f),
            JokeDataModel(2, "Category 2", "joke 2", 4, 4.23f),
            JokeDataModel(3, "Category 3", "joke 3", 4, 4f),
            JokeDataModel(4, "Category 2", "joke 4", 4, 3.22f),
            JokeDataModel(5, "Category 1", "joke 5", 4, 4f),
            JokeDataModel(6, "Category 1", "joke 6", 4, 4.01f),
            JokeDataModel(9, "Category 1", "joke 9", 4, 4f),
            JokeDataModel(12, "Category 3", "joke 12", 4, 4f),
            JokeDataModel(13, "Category 1", "joke 13", 4, 4f),
            JokeDataModel(15, "Category 2", "joke 15", 4, 1.9f),
            JokeDataModel(22, "Category 1", "joke 22", 4, 4f)
    )
}