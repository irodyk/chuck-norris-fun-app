package com.yurets.chucknorrisfunapp.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yurets.chucknorrisfunapp.BR
import com.yurets.chucknorrisfunapp.viewmodel.JokeViewModel
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.databinding.FragmentPagerJokeItemBinding
import com.yurets.chucknorrisfunapp.ui.abs.BaseFragment

class JokePagerFragment: BaseFragment() {

    companion object {
        fun newInstance(jokeViewModel: JokeViewModel?) : JokePagerFragment {
            val args = Bundle()
            args.putParcelable("joke", jokeViewModel)
            val fragment = JokePagerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentPagerJokeItemBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_pager_joke_item, container , false)
        val rootView : View = binding.root

        val joke = arguments!!.get("joke")
        binding.setVariable(BR.joke, joke)
        binding.executePendingBindings()

        return rootView
    }
}