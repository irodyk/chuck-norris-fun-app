package com.yurets.domain.model

import com.yurets.data.model.JokeDataModel

data class Joke (val id: Int, val text: String, val userVote: Int, val overallRating: Float){

    object Mapper {

        val jokeMapper: (JokeDataModel) -> Joke = { jokeDataModel ->
            Joke(id = jokeDataModel.id, text = jokeDataModel.text,
                    userVote = jokeDataModel.userVote, overallRating = jokeDataModel.overallRating)
        }

        val jokeDataModelMapper: (Joke) -> JokeDataModel = { joke ->
            JokeDataModel(id = joke.id, text = joke.text,
                    userVote = joke.userVote, overallRating = joke.overallRating)
        }
    }
}