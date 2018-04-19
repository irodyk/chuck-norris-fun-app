package com.yurets.chucknorrisfunapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.yurets.chucknorrisfunapp.ui.fragment.pager.JokePagerItemFragment
import com.yurets.chucknorrisfunapp.viewmodel.AllJokesViewModel

const val OFFSET_LIMIT = 5

class JokePagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    var jokes : List<AllJokesViewModel.JokeItem> = emptyList()

    override fun getItem(position: Int): Fragment {
        return JokePagerItemFragment.newInstance(jokes[position])
    }

    override fun getCount(): Int {
        return jokes.size
    }
}