package com.yurets.chucknorrisfunapp.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.ui.abs.BaseFragment
import com.yurets.chucknorrisfunapp.viewmodel.*
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CategoryFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CategoryViewModel

    private var isLoading = false

    private val stateObserver = Observer<State<FavoriteViewModel.JokeItem>> { state ->
        state.let {
            when (state) {
                is DefaultState -> {
                    isLoading = false

                }
                is LoadingState -> {
                    isLoading = true
                }
                is PaginatingState -> {
                    isLoading = true
                }
                is ErrorState -> {
                    isLoading = false
                }
            }
        }
    }


    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoryViewModel::class.java)
        observeViewModel()
        savedInstanceState?.let { viewModel.restoreJokeList() } ?: viewModel.updateJokeList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val rootView = inflater.inflate(R.layout.fragment_category, container , false)


        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun observeViewModel() {
    }
}