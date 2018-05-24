package com.yurets.chucknorrisfunapp.di.component.sub

import com.yurets.chucknorrisfunapp.di.module.fragment.FavoriteFragmentModule
import com.yurets.chucknorrisfunapp.di.module.fragment.PagerFragmentModule
import com.yurets.chucknorrisfunapp.di.module.fragment.RatingFragmentModule
import com.yurets.chucknorrisfunapp.ui.activity.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(
        PagerFragmentModule::class,
        FavoriteFragmentModule::class,
        RatingFragmentModule::class
))
interface HomeActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}