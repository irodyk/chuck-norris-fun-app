package com.yurets.chucknorrisfunapp.di.component

import android.app.Application
import android.content.Context
import com.yurets.chucknorrisfunapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun application(): Application
    fun context(): Context
}
