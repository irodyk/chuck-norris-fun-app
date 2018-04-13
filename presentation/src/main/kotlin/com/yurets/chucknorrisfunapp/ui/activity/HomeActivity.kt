package com.yurets.chucknorrisfunapp.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetBehavior
import android.view.MenuItem
import android.view.View
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.ui.abs.BaseActivity
import kotlinx.android.synthetic.main.bottom_hidden_navigation_bar.*


class HomeActivity : BaseActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation.setOnNavigationItemSelectedListener(this)

        val bottomSheetBehaviour = BottomSheetBehavior.from(bottomNavigationRoot) as BottomSheetBehavior
        bottomSheetBehaviour.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_full_list -> {}
            R.id.action_favorites -> {}
            R.id.action_rating -> {}
            else -> throw IllegalArgumentException("Menu item id is invalid")
        }
        return true
    }
}
