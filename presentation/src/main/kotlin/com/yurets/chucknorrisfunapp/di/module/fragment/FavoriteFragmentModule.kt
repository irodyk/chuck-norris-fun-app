package com.yurets.chucknorrisfunapp.di.module.fragment

import android.support.v4.app.Fragment
import com.yurets.chucknorrisfunapp.ui.fragment.FavoriteFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Subcomponent/*(modules = ...)*/
interface FavoriteFragmentSubcomponent: AndroidInjector<FavoriteFragment> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<FavoriteFragment>()
}

@Module(subcomponents = arrayOf(FavoriteFragmentSubcomponent::class))
abstract class FavoriteFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(FavoriteFragment::class)
    abstract fun bindFavoriteFragmentInjectorFactory(builder: FavoriteFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}
