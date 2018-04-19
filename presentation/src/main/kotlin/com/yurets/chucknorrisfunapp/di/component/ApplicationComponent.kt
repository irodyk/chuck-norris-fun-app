package com.yurets.chucknorrisfunapp.di.component

import com.yurets.chucknorrisfunapp.ChuckNorrisFunApp
import com.yurets.chucknorrisfunapp.di.module.ViewModelFactoryModule
import com.yurets.chucknorrisfunapp.di.module.ViewModelModule
import com.yurets.chucknorrisfunapp.di.module.ApplicationModule
import com.yurets.chucknorrisfunapp.di.module.activity.HomeActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        HomeActivityModule::class
))

interface ApplicationComponent {
    fun inject(app: ChuckNorrisFunApp)
}
