package com.yurets.chucknorrisfunapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_IO
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_MAIN_THREAD
import com.yurets.domain.interactor.GetJokeRankingUseCase
import com.yurets.domain.model.Joke
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class RatingViewModel
@Inject constructor (private val getJokeRankingUseCase: GetJokeRankingUseCase,
                     @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
                     @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler)
    : ViewModel(){

    data class JokeItem(val id: Int, val text: String, val userVote: Int, val overallRating: Float)

    val liveDataState =  MutableLiveData<State<JokeItem>>()

    init {
        liveDataState.value = DefaultState(0, emptyList())
    }

    fun updateJokeList() {
        val pageNum = obtainCurrentPageNum()
        liveDataState.value = if (pageNum == 0)
            LoadingState(pageNum, obtainCurrentData())
        else
            PaginatingState(pageNum, obtainCurrentData())
        getJokeList(pageNum)
    }

    fun resetJokeList() {
        val pageNum = 0
        liveDataState.value = LoadingState(pageNum, emptyList())
        updateJokeList()
    }

    fun restoreJokeList() {
        val pageNum = obtainCurrentPageNum()
        liveDataState.value = DefaultState(pageNum, obtainCurrentData())
    }

    private fun getJokeList(page: Int) {
        getJokeRankingUseCase.getJokeRanking(page)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onJokeListReceived, this::onError)
    }

    private fun onJokeListReceived(jokeList: List<Joke>) {

        val jokeItemList = jokeList.map { JokeItem(id = it.id, text = it.text,
                userVote = it.userVote, overallRating = it.overallRating)  }

        val currentJokeList = obtainCurrentData().toMutableList()
        val currentpageNum = obtainCurrentPageNum() + 1
        currentJokeList.addAll(jokeItemList)
        liveDataState.value = DefaultState(currentpageNum, currentJokeList)
    }

    private fun onError(error: Throwable) {
        val pageNum = liveDataState.value?.pageNum ?: 0
        liveDataState.value = ErrorState(error.message
                ?: "", pageNum, obtainCurrentData())
    }

    private fun obtainCurrentPageNum() = liveDataState.value?.pageNum ?: 0

    private fun obtainCurrentData() = liveDataState.value?.data ?: emptyList()
    
}