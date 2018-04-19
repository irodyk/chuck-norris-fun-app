package com.yurets.chucknorrisfunapp.di.module.fragment

import android.support.v4.app.Fragment
import com.yurets.chucknorrisfunapp.ui.fragment.RatingFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Subcomponent/*(modules = ...)*/
interface RatingFragmentSubcomponent: AndroidInjector<RatingFragment> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<RatingFragment>()
}

@Module(subcomponents = arrayOf(RatingFragmentSubcomponent::class))
abstract class RatingFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(RatingFragment::class)
    abstract fun bindRatingFragmentInjectorFactory(builder: RatingFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}