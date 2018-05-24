package com.yurets.domain.model

import com.yurets.data.model.JokeDataModel

data class Joke (val id: Int, val category: String, val text: String, val userVote: Int, val overallRating: Float){

    object Mapper {

        val jokeMapper: (JokeDataModel) -> Joke = { jokeDataModel ->
            Joke(id = jokeDataModel.id, category = jokeDataModel.category, text = jokeDataModel.value,
                    userVote = jokeDataModel.userVote, overallRating = jokeDataModel.overallRating)
        }

        val jokeDataModelMapper: (Joke) -> JokeDataModel = { joke ->
            JokeDataModel(id = joke.id, category = joke.category, value = joke.text,
                    userVote = joke.userVote, overallRating = joke.overallRating)
        }
    }
}