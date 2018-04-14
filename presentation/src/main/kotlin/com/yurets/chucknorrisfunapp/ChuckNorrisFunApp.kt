package com.yurets.chucknorrisfunapp

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.yurets.chucknorrisfunapp.di.component.ApplicationComponent
import com.yurets.chucknorrisfunapp.di.component.DaggerApplicationComponent
import com.yurets.chucknorrisfunapp.di.module.ApplicationModule

class ChuckNorrisFunApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initializeInjector()
        initializeLeakCanary()
    }

    private fun initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    private fun initializeLeakCanary() {
        if(BuildConfig.DEBUG){
            LeakCanary.install(this)
        }
    }
}