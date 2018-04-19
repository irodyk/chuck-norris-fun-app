package com.yurets.chucknorrisfunapp.di.component.sub

import com.yurets.chucknorrisfunapp.di.module.PagerFragmentModule
import com.yurets.chucknorrisfunapp.ui.activity.HomeActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(PagerFragmentModule::class))
interface HomeActivitySubcomponent : AndroidInjector<HomeActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>()
}