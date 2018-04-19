package com.yurets.chucknorrisfunapp.di.module.fragment

import android.support.v4.app.Fragment
import com.yurets.chucknorrisfunapp.ui.fragment.AllJokesFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Subcomponent/*(modules = ...)*/
interface PagerFragmentSubcomponent: AndroidInjector<AllJokesFragment> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<AllJokesFragment>()
}

@Module(subcomponents = arrayOf(PagerFragmentSubcomponent::class))
abstract class PagerFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(AllJokesFragment::class)
    abstract fun bindPagerFragmentInjectorFactory(builder: PagerFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}