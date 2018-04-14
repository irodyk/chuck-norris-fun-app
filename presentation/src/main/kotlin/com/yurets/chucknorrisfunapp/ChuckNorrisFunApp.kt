package com.yurets.chucknorrisfunapp

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.yurets.chucknorrisfunapp.di.component.ApplicationComponent
import com.yurets.chucknorrisfunapp.di.component.DaggerApplicationComponent
import com.yurets.chucknorrisfunapp.di.module.ApplicationModule

class ChuckNorrisFunApp : Application() {

    lateinit var applicationComponent: ApplicationComponent
    lateinit var leakRefWatcher: RefWatcher

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this))
            return

        leakRefWatcher = LeakCanary.install(this)

        initializeInjector()
    }

    private fun initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}