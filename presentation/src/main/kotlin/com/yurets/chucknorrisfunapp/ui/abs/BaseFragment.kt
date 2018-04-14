package com.yurets.chucknorrisfunapp.ui.abs

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.squareup.leakcanary.RefWatcher
import com.yurets.chucknorrisfunapp.ChuckNorrisFunApp


abstract class BaseFragment : Fragment() {


    companion object {
        fun handleBackPressed(fm: FragmentManager): Boolean {
            if (fm.fragments != null) {
                for (frag in fm.fragments) {
                    if (frag != null && frag.isVisible && frag is BaseFragment) {
                        if (frag.onBackPressed()) {
                            return true
                        }
                    }
                }
            }
            return false
        }
    }

    protected fun onBackPressed(): Boolean {
        val fm = childFragmentManager
        if (handleBackPressed(fm)) {
            return true
        } else if (userVisibleHint && fm.backStackEntryCount > 0) {
            fm.popBackStack()
            return true
        }
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity?.application as ChuckNorrisFunApp).leakRefWatcher.watch(this)
    }
}