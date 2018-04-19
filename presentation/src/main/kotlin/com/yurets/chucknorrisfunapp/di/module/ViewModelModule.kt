package com.yurets.chucknorrisfunapp.di.module

import android.arch.lifecycle.ViewModel
import com.yurets.chucknorrisfunapp.viewmodel.JokePagerViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(JokePagerViewModel::class)
    abstract fun bindCryptoListViewModel(pagerViewModel: JokePagerViewModel) : ViewModel
}