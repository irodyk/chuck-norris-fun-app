package com.yurets.chucknorrisfunapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.yurets.chucknorrisfunapp.ui.fragment.JokePagerFragment
import com.yurets.chucknorrisfunapp.viewmodel.JokeViewModel

class JokePagerAdapter(fm : FragmentManager, private var jokes : MutableList<JokeViewModel>)
    : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return JokePagerFragment.newInstance( jokes[position])
    }

    override fun getCount(): Int {
        return jokes.size
    }

    fun addJokes(newJokes : MutableList<JokeViewModel>){
        jokes.addAll(newJokes)
        jokes.sort()
        notifyDataSetChanged()
    }
}