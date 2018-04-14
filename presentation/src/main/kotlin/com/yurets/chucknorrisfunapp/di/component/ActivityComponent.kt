package com.yurets.chucknorrisfunapp.di.component

import com.yurets.chucknorrisfunapp.di.module.ActivityModule
import com.yurets.chucknorrisfunapp.di.scope.PerActivity
import com.yurets.chucknorrisfunapp.ui.abs.BaseActivity
import dagger.Component

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    //Exposed to sub-graphs.
    fun inject(activity: BaseActivity)
}