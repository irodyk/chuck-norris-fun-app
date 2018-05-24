package com.yurets.data.datasource.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.yurets.data.model.JokeDataModel

@Entity(tableName = "joke")
data class JokeEntity (@PrimaryKey val jokeId: Int,
                       val category: String,
                       val value: String,
                       val userVote: Int,
                       val overallRating: Float) {

    object Mapper {

        val jokeEntityMapper: (JokeDataModel) -> JokeEntity = { jokeDataModel ->
            JokeEntity(jokeId = jokeDataModel.id, category = jokeDataModel.category, value = jokeDataModel.value,
                    userVote = jokeDataModel.userVote, overallRating = jokeDataModel.overallRating)
        }

        val jokeDataModelMapper: (JokeEntity) -> JokeDataModel = { joke ->
            JokeDataModel(id = joke.jokeId, category = joke.category, value = joke.value,
                    userVote = joke.userVote, overallRating = joke.overallRating)
        }
    }

    object DataModelMapper {

        fun from (from: JokeDataModel) = JokeEntity(jokeId = from.id, category = from.category, value = from.value,
                userVote = from.userVote, overallRating = from.overallRating)

        fun to (to: JokeEntity) = JokeDataModel(id = to.jokeId, category = to.category, value = to.value,
                userVote = to.userVote, overallRating = to.overallRating)
    }
}