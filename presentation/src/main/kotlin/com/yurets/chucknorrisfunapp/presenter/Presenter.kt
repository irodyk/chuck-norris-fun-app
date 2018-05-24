package com.yurets.chucknorrisfunapp.presenter

interface Presenter<V> {

    /**
     * Ui to set the view for backward communication.
     * @param view - implementation of a specific view.
     */
    fun setView(view: V)

    /**
     * Ui to notify observables to be disposed.
     */
    fun dispose()
}