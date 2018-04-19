package com.yurets.chucknorrisfunapp.di.module.activity

import android.app.Activity
import com.yurets.chucknorrisfunapp.di.component.sub.HomeActivitySubcomponent
import com.yurets.chucknorrisfunapp.ui.activity.HomeActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(HomeActivitySubcomponent::class))
abstract class HomeActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    abstract fun bindHomeActivityInjectorFactory(builder: HomeActivitySubcomponent.Builder): AndroidInjector.Factory<out Activity>
}