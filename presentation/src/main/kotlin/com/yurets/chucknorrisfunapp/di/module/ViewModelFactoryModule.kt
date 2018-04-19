package com.yurets.chucknorrisfunapp.di.module

import android.arch.lifecycle.ViewModelProvider
import com.yurets.chucknorrisfunapp.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}