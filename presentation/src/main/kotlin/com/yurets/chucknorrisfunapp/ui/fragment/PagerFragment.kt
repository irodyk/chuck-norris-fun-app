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
        list.add(JokeViewModel(2, "joke 2", 4, 4))
        list.add(JokeViewModel(4, "joke 4", 4, 4))
        list.add(JokeViewModel(6, "joke 6", 4, 4))
        list.add(JokeViewModel(1, "joke 1", 4, 4))
        list.add(JokeViewModel(15, "joke 15", 4, 4))
        list.add(JokeViewModel(22, "joke 22", 4, 4))
        list.add(JokeViewModel(5, "joke 5", 4, 4))
        list.sort()

        rootView.jokePager.adapter = JokePagerAdapter(fragmentManager!!, list)

        return rootView
    }
}