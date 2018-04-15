package com.yurets.chucknorrisfunapp.ui.abs

import android.support.v4.app.Fragment
import com.yurets.chucknorrisfunapp.ChuckNorrisFunApp


abstract class BaseFragment : Fragment() {

    override fun onDestroy() {
        super.onDestroy()
        (activity?.application as ChuckNorrisFunApp).leakRefWatcher.watch(this)
    }
}