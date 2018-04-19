package com.yurets.chucknorrisfunapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_IO
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_MAIN_THREAD
import com.yurets.chucknorrisfunapp.viewmodel.state.*
import com.yurets.domain.interactor.JokeListUseCase
import com.yurets.domain.model.Joke
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class JokePagerViewModel
@Inject constructor (private val jokeListUseCase: JokeListUseCase,
                     @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
                     @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler)
    : ViewModel(){

    data class JokeViewModelItem(val id: Int, val text: String, val userVote: Int, val overallRating: Float)

    val stateLiveData =  MutableLiveData<JokePagerState>()

    init {
        stateLiveData.value = DefaultState(0, emptyList())
    }

    fun updateJokeList() {
        val pagePos = obtainCurrentPagePos()
        stateLiveData.value = if (pagePos == 0)
            LoadingState(pagePos, obtainCurrentData())
        else
            PaginatingState(pagePos, obtainCurrentData())
        getJokeList(pagePos)
    }

    fun resetJokeList() {
        val pagePos = 0
        stateLiveData.value = LoadingState(pagePos, emptyList())
        updateJokeList()
    }

    fun restoreJokeList() {
        val pagePos = obtainCurrentPagePos()
        stateLiveData.value = DefaultState(pagePos, obtainCurrentData())
    }

    private fun getJokeList(page: Int) {
        jokeListUseCase.getJokeList(page)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onJokeListReceived, this::onError)
    }

    private fun onJokeListReceived(jokeList: List<Joke>) {

        val jokeViewModelItemList = jokeList.map { JokeViewModelItem(id = it.id, text = it.text,
                userVote = it.userVote, overallRating = it.overallRating)  }

        val currentJokeList = obtainCurrentData().toMutableList()
        val currentpagePos = obtainCurrentPagePos() + 1
        currentJokeList.addAll(jokeViewModelItemList)
        stateLiveData.value = DefaultState(currentpagePos, currentJokeList)
    }

    private fun onError(error: Throwable) {
        val pagePos = stateLiveData.value?.pagePos ?: 0
        stateLiveData.value = ErrorState(error.message ?: "", pagePos, obtainCurrentData())
    }

    private fun obtainCurrentPagePos() = stateLiveData.value?.pagePos ?: 0

    private fun obtainCurrentData() = stateLiveData.value?.data ?: emptyList()
}