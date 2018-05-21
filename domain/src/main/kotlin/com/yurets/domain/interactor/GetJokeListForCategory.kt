package com.yurets.domain.interactor

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.data.model.CategoryDataModel
import com.yurets.domain.model.Category
import com.yurets.domain.model.Joke
import io.reactivex.Observable
import javax.inject.Inject

class GetJokeListForCategory @Inject constructor(private val jokeRepository: JokeRepositoryBoundary){

    fun getJokeListForCategory(page: Int, category: Category): Observable<List<Joke>> {

        val categoryDataModel : CategoryDataModel = Category.Mapper.categoryDataModelMapper(category)

        return jokeRepository.getListForCategory(categoryDataModel).map {
            jokeDataModels -> jokeDataModels.map(Joke.Mapper.jokeMapper)
        }
    }
}