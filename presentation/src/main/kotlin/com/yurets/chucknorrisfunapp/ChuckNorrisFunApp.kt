package com.yurets.chucknorrisfunapp

import android.app.Activity
import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.yurets.chucknorrisfunapp.di.component.DaggerApplicationComponent
import com.yurets.chucknorrisfunapp.di.module.ApplicationModule
import com.yurets.chucknorrisfunapp.di.module.RepositoryModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ChuckNorrisFunApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    lateinit var leakRefWatcher: RefWatcher

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this))
            return

        leakRefWatcher = LeakCanary.install(this)

        initializeInjector()
    }

    private fun initializeInjector() {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .repositoryModule(RepositoryModule())
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}