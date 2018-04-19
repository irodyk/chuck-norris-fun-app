package com.yurets.chucknorrisfunapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.yurets.chucknorrisfunapp.ui.fragment.JokePagerFragment
import com.yurets.chucknorrisfunapp.viewmodel.JokePagerViewModel
import com.yurets.domain.model.Joke

const val OFFSET_LIMIT = 5

class JokePagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    var jokes : List<JokePagerViewModel.JokeViewModelItem> = emptyList()

    override fun getItem(position: Int): Fragment {
        return JokePagerFragment.newInstance(jokes[position])
    }

    override fun getCount(): Int {
        return jokes.size
    }
}