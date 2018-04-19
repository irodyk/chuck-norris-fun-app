package com.yurets.chucknorrisfunapp.ui.fragment.pager

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import com.yurets.chucknorrisfunapp.BR
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.databinding.FragmentPagerJokeItemBinding
import com.yurets.chucknorrisfunapp.ui.abs.BaseFragment
import com.yurets.chucknorrisfunapp.viewmodel.AllJokesViewModel

class JokePagerItemFragment: BaseFragment() {

    private lateinit var jokeVmItem: AllJokesViewModel.JokeItem

    companion object {

        fun newInstance(jokeVmItem : AllJokesViewModel.JokeItem) : JokePagerItemFragment {
            val fragment = JokePagerItemFragment()
            fragment.jokeVmItem = jokeVmItem
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentPagerJokeItemBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_pager_joke_item, container , false)
        val rootView : View = binding.root

        binding.setVariable(BR.jokeVmItem, jokeVmItem)
        binding.executePendingBindings()

        return rootView
    }

    @BindingAdapter("rating")
    fun rating(view: RatingBar, value: String) {
        view.rating = value.toFloat()
    }
}