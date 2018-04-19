package com.yurets.chucknorrisfunapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_IO
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_MAIN_THREAD
import com.yurets.domain.interactor.GetFromAllJokesUseCase
import com.yurets.domain.model.Joke
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class AllJokesViewModel
@Inject constructor (private val getFromAllJokesUseCase: GetFromAllJokesUseCase,
                     @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
                     @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler)
    : ViewModel(){

    data class JokeItem(val id: Int, val text: String, val userVote: Int, val overallRating: Float)

    val liveDataState =  MutableLiveData<State<JokeItem>>()

    init {
        liveDataState.value = DefaultState(0, emptyList())
    }

    fun updateJokeList() {
        val pagePos = obtainCurrentPagePos()
        liveDataState.value = if (pagePos == 0)
            LoadingState(pagePos, obtainCurrentData())
        else
            PaginatingState(pagePos, obtainCurrentData())
        getJokeList(pagePos)
    }

    fun resetJokeList() {
        val pagePos = 0
        liveDataState.value = LoadingState(pagePos, emptyList())
        updateJokeList()
    }

    fun restoreJokeList() {
        val pagePos = obtainCurrentPagePos()
        liveDataState.value = DefaultState(pagePos, obtainCurrentData())
    }

    private fun getJokeList(page: Int) {
        getFromAllJokesUseCase.getJokeList(page)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onJokeListReceived, this::onError)
    }

    private fun onJokeListReceived(jokeList: List<Joke>) {

        val jokeItemList = jokeList.map { JokeItem(id = it.id, text = it.text,
                userVote = it.userVote, overallRating = it.overallRating)  }

        val currentJokeList = obtainCurrentData().toMutableList()
        val currentpagePos = obtainCurrentPagePos() + 1
        currentJokeList.addAll(jokeItemList)
        liveDataState.value = DefaultState(currentpagePos, currentJokeList)
    }

    private fun onError(error: Throwable) {
        val pagePos = liveDataState.value?.pageNum ?: 0
        liveDataState.value = ErrorState(error.message
                ?: "", pagePos, obtainCurrentData())
    }

    private fun obtainCurrentPagePos() = liveDataState.value?.pageNum ?: 0

    private fun obtainCurrentData() = liveDataState.value?.data ?: emptyList()
}