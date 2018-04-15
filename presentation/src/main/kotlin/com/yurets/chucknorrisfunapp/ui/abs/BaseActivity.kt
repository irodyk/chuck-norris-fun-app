package com.yurets.chucknorrisfunapp.ui.abs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.yurets.chucknorrisfunapp.ChuckNorrisFunApp
import com.yurets.chucknorrisfunapp.di.component.ApplicationComponent


abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector((application as ChuckNorrisFunApp).applicationComponent)
        super.onCreate(savedInstanceState)
    }

    protected fun setFragment(containerViewId: Int, fragment: Fragment) {
        val backStateName = fragment.javaClass.simpleName
        val fragmentPopped = supportFragmentManager.popBackStackImmediate(backStateName, 0)

        if (!fragmentPopped) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(containerViewId, fragment)
            ft.addToBackStack(backStateName)
            ft.commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1){
            finish()
        }
        else {
            super.onBackPressed()
        }
    }

    protected abstract fun initializeInjector(applicationComponent: ApplicationComponent)
}