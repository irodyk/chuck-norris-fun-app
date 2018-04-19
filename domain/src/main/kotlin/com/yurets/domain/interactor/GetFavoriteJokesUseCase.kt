package com.yurets.domain.interactor

import com.yurets.domain.model.Joke
import io.reactivex.Single
import javax.inject.Inject

class GetFavoriteJokesUseCase @Inject constructor(){


    fun getFavoriteJokes(page: Int): Single<List<Joke>> {

        val list = mutableListOf<Joke>()

        list.add(Joke(1, "joke 1", 4, 4.7f))
        list.add(Joke(2, "joke 2", 4, 4.23f))
        list.add(Joke(3, "joke 3", 4, 4f))
        list.add(Joke(4, "joke 4", 4, 3.22f))
        list.add(Joke(5, "joke 5", 4, 4f))
        list.add(Joke(6, "joke 6", 4, 4.01f))
        list.add(Joke(9, "joke 9", 4, 4f))
        list.add(Joke(12, "joke 12", 4, 4f))
        list.add(Joke(13, "joke 13", 4, 4f))
        list.add(Joke(15, "joke 15", 4, 1.9f))
        list.add(Joke(22, "joke 22", 4, 4f))

        return Single.just(list)
    }


}