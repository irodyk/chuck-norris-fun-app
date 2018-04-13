package com.yurets.chucknorrisfunapp

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class ChuckNorrisFunApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeLeakCanary()
    }

    private fun initializeLeakCanary() {
        if(BuildConfig.DEBUG){
            LeakCanary.install(this)
        }
    }
}