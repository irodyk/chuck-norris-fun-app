package com.yurets.chucknorrisfunapp.ui.abs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.yurets.chucknorrisfunapp.ChuckNorrisFunApp
import com.yurets.chucknorrisfunapp.di.component.ApplicationComponent


abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector((application as ChuckNorrisFunApp).applicationComponent)
        super.onCreate(savedInstanceState)
    }

    protected fun addFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.add(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    protected fun addFragmentToBackStack(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.add(containerViewId, fragment, fragment.javaClass.simpleName)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        fragmentTransaction.commit()
    }

    protected fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment)
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (!BaseFragment.handleBackPressed(supportFragmentManager)) {
            super.onBackPressed()
        }
    }

    protected abstract fun initializeInjector(applicationComponent: ApplicationComponent)
}