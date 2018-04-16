package com.yurets.chucknorrisfunapp.ui.fragment

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
import com.yurets.chucknorrisfunapp.viewmodel.JokeViewModel


class JokePagerFragment: BaseFragment() {

    companion object {
        const val JOKE_KEY = "joke"

        fun newInstance(jokeViewModel: JokeViewModel?) : JokePagerFragment {
            val args = Bundle()
            args.putParcelable(JOKE_KEY, jokeViewModel)
            val fragment = JokePagerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentPagerJokeItemBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_pager_joke_item, container , false)
        val rootView : View = binding.root

        val joke = arguments!!.get(JOKE_KEY)
        binding.setVariable(BR.joke, joke)
        binding.executePendingBindings()

        return rootView
    }

    @BindingAdapter("rating")
    fun rating(view: RatingBar, value: String) {
        view.rating = value.toFloat()
    }
}