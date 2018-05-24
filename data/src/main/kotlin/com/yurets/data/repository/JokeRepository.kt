package com.yurets.data.repository

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.data.datasource.local.JokeDao
import com.yurets.data.datasource.local.entity.JokeEntity
import com.yurets.data.model.JokeDataModel
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

class JokeRepository @Inject constructor(val jokeDao: JokeDao) : JokeRepositoryBoundary {


    override fun jokesCount(): Int {
        return jokeDao.countJokes()
    }

    override fun prePopulateDb(jokeList: List<JokeDataModel>) : Maybe<Int> {
        return Maybe.just(jokeDao.insertJokes(jokeList
                .map { JokeEntity.DataModelMapper.from(it) })
                .size)
    }

    override fun getAllJokesList(): Flowable<List<JokeDataModel>> {
        return jokeDao.queryJokes(20).map { it -> it.map(JokeEntity.Mapper.jokeDataModelMapper)}
    }

    override fun getFavoriteList(): Flowable<List<JokeDataModel>> {
        return jokeDao.queryJokes(20).map { it -> it.map(JokeEntity.Mapper.jokeDataModelMapper)}
    }

    override fun getRatingList(): Flowable<List<JokeDataModel>> {
        return jokeDao.queryJokes(20).map { it -> it.map(JokeEntity.Mapper.jokeDataModelMapper)}
    }

    override fun getCategoryList(): Flowable<List<String>> {
        return jokeDao.queryCategories(20)
    }

    override fun getListForCategory(category: String): Flowable<List<JokeDataModel>> {
        return jokeDao.queryJokes(20).map { it -> it.map(JokeEntity.Mapper.jokeDataModelMapper)}
    }

}