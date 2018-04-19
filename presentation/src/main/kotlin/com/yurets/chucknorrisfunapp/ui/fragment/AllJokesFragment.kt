package com.yurets.chucknorrisfunapp.ui.fragment

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.adapter.JokePagerAdapter
import com.yurets.chucknorrisfunapp.adapter.OFFSET_LIMIT
import com.yurets.chucknorrisfunapp.ui.abs.BaseFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import com.yurets.chucknorrisfunapp.viewmodel.*
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_pager.view.*
import javax.inject.Inject

class AllJokesFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: AllJokesViewModel

    private val jokePagerAdapter by lazy { JokePagerAdapter(childFragmentManager) }
    private var isLoading = false

    private val stateObserver = Observer<State<AllJokesViewModel.JokeItem>> { state ->
        state.let {
            when (state) {
                is DefaultState -> {
                    isLoading = false
                    jokePagerAdapter.jokes = it!!.data
                    jokePagerAdapter.notifyDataSetChanged()
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
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AllJokesViewModel::class.java)
        observeViewModel()
        savedInstanceState?.let { viewModel.restoreJokeList() } ?: viewModel.updateJokeList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val rootView = inflater.inflate(R.layout.fragment_pager, container , false)

        rootView.jokePager.adapter = jokePagerAdapter
        rootView.jokePager.offscreenPageLimit = OFFSET_LIMIT

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.liveDataState.removeObserver(stateObserver)
    }

    private fun observeViewModel() {
        viewModel.liveDataState.observe(this, stateObserver)
    }
}