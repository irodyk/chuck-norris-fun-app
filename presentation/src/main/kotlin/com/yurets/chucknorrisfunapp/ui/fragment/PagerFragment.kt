package com.yurets.chucknorrisfunapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yurets.chucknorrisfunapp.viewmodel.JokeViewModel
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.adapter.JokePagerAdapter
import com.yurets.chucknorrisfunapp.ui.abs.BaseFragment
import kotlinx.android.synthetic.main.fragment_pager.view.*

class PagerFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val rootView = inflater.inflate(R.layout.fragment_pager, container , false)

        val list = mutableListOf<JokeViewModel>()
        list.add(JokeViewModel(2, "joke 2", 4, 4.23f))
        list.add(JokeViewModel(4, "joke 4", 4, 3.22f))
        list.add(JokeViewModel(6, "joke 6", 4, 4.01f))
        list.add(JokeViewModel(1, "joke 1", 4, 4.7f))
        list.add(JokeViewModel(15, "joke 15", 4, 1.9f))
        list.add(JokeViewModel(22, "joke 22", 4, 4f))
        list.add(JokeViewModel(5, "joke 5", 4, 4f))
        list.add(JokeViewModel(12, "joke 12", 4, 4f))
        list.add(JokeViewModel(13, "joke 13", 4, 4f))
        list.add(JokeViewModel(3, "joke 3", 4, 4f))
        list.add(JokeViewModel(9, "joke 9", 4, 4f))
        list.sort()

        rootView.jokePager.adapter = JokePagerAdapter(childFragmentManager, list)
        rootView.jokePager.offscreenPageLimit = JokePagerAdapter.OFFSET_LIMIT

        return rootView
    }
}