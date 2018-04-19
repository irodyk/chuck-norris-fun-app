package com.yurets.chucknorrisfunapp.di.module

import android.arch.lifecycle.ViewModel
import com.yurets.chucknorrisfunapp.viewmodel.AllJokesViewModel
import com.yurets.chucknorrisfunapp.viewmodel.FavoriteViewModel
import com.yurets.chucknorrisfunapp.viewmodel.RatingViewModel
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
    @ViewModelKey(AllJokesViewModel::class)
    abstract fun bindAllJokesViewModel(allJokesViewModel: AllJokesViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(favoriteViewModel: FavoriteViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RatingViewModel::class)
    abstract fun bindRatingViewModel(ratingViewModel: RatingViewModel) : ViewModel
}