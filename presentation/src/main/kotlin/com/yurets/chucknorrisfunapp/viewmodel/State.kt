package com.yurets.chucknorrisfunapp.viewmodel

abstract class State<out T> {

    abstract val pageNum: Int
    abstract val data: List<T>
}
data class DefaultState<out T>(override val pageNum: Int, override val data: List<T>) : State<T>()
data class LoadingState<out T>(override val pageNum: Int, override val data: List<T>) : State<T>()
data class PaginatingState<out T>(override val pageNum: Int, override val data: List<T>) : State<T>()
data class ErrorState<out T>(val errorMessage: String, override val pageNum: Int, override val data: List<T>) : State<T>()