package com.yurets.chucknorrisfunapp.viewmodel.state

import com.yurets.chucknorrisfunapp.viewmodel.JokePagerViewModel

sealed class JokePagerState {
    abstract val pagePos: Int
    abstract val data: List<JokePagerViewModel.JokeViewModelItem>
}
data class DefaultState(override val pagePos: Int, override val data: List<JokePagerViewModel.JokeViewModelItem>) : JokePagerState()
data class LoadingState(override val pagePos: Int, override val data: List<JokePagerViewModel.JokeViewModelItem>) : JokePagerState()
data class PaginatingState(override val pagePos: Int, override val data: List<JokePagerViewModel.JokeViewModelItem>) : JokePagerState()
data class ErrorState(val errorMessage: String, override val pagePos: Int, override val data: List<JokePagerViewModel.JokeViewModelItem>) : JokePagerState()
