package com.yurets.domain.interactor

import com.yurets.data.JokeRepositoryBoundary
import com.yurets.domain.model.Category
import io.reactivex.Observable
import javax.inject.Inject

class GetCategoryList @Inject constructor(private val jokeRepository: JokeRepositoryBoundary){

    fun getCategoryList(): Observable<List<Category>> {

        return jokeRepository.getCategoryList().map { categoryDataModels ->
            categoryDataModels.map(Category.Mapper.categoryMapper)
        }
    }
}