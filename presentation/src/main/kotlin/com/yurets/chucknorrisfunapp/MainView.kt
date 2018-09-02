package com.yurets.chucknorrisfunapp

interface MainView{

    /**
     * Notify the Ui about error occurred.
     * @param msg - error message.
     */
    fun onError(msg: String?)
}