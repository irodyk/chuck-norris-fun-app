package com.yurets.chucknorrisfunapp.presenter

import android.util.Log
import com.yurets.chucknorrisfunapp.MainView
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_IO
import com.yurets.chucknorrisfunapp.di.module.SCHEDULER_MAIN_THREAD
import com.yurets.domain.interactor.PrePopulateDb
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Named

class MainPresenter @Inject constructor (private val prePopulateDb: PrePopulateDb,
                    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
                    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler)
    : Presenter<MainView> {

    private lateinit var view: MainView

    private val disposables = mutableListOf<Disposable>()

    override fun setView(view: MainView) {
        this.view = view
    }

    override fun dispose() {
        disposables.forEach {it.dispose()}
    }

    fun prePopulateDb(){
        disposables.add(prePopulateDb.prePopulateDb()
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onPopulationComplete, this::onError))
    }


    private fun onPopulationComplete(insertedRows: Int){
        Log.d("MainPresenter", "insertedRows: $insertedRows")
    }

    private fun onError(t: Throwable){
        Log.e("MainPresenter", "Error: ${t.message}")
        view.onError(t.message)
    }
}