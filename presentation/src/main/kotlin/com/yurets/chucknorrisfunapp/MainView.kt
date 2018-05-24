package com.yurets.chucknorrisfunapp

interface MainView{

    /**
     * Notify the Ui about error occured.
     * @param msg - error message.
     */
    fun onError(msg: String?)
}