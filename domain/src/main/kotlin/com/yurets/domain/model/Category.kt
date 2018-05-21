package com.yurets.domain.model

import com.yurets.data.model.CategoryDataModel

class Category (val id: Int, val name: String){

    object Mapper {

        val categoryMapper: (CategoryDataModel) -> Category = { categoryDataModel ->
            Category(id = categoryDataModel.id, name = categoryDataModel.name)
        }

        val categoryDataModelMapper: (Category) -> CategoryDataModel = { category ->
            CategoryDataModel(id = category.id, name = category.name)
        }
    }
}