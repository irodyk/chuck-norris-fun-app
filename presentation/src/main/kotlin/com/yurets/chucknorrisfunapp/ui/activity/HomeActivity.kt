package com.yurets.chucknorrisfunapp.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetBehavior
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.di.component.ApplicationComponent
import com.yurets.chucknorrisfunapp.di.component.DaggerActivityComponent
import com.yurets.chucknorrisfunapp.di.module.ActivityModule
import com.yurets.chucknorrisfunapp.ui.abs.BaseActivity
import com.yurets.chucknorrisfunapp.ui.fragment.FavoriteFragment
import com.yurets.chucknorrisfunapp.ui.fragment.PagerFragment
import com.yurets.chucknorrisfunapp.ui.fragment.RatingFragment
import kotlinx.android.synthetic.main.bottom_hidden_navigation_bar.*


class HomeActivity : BaseActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomSheetBehaviour : BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        addFragment(R.id.container_main, PagerFragment())

        bottomNavigation.setOnNavigationItemSelectedListener(this)

        bottomSheetBehaviour = BottomSheetBehavior.from(bottomNavigationRoot) as BottomSheetBehavior
        bottomSheetBehaviour.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        bottomSheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
        when (item.itemId) {
            R.id.action_full_list -> replaceFragment(R.id.container_main, PagerFragment())
            R.id.action_favorites -> replaceFragment(R.id.container_main, FavoriteFragment())
            R.id.action_rating -> replaceFragment(R.id.container_main, RatingFragment())
            else -> throw IllegalArgumentException("Menu item id is invalid")
        }
        return true
    }

    override fun initializeInjector(applicationComponent: ApplicationComponent) {
        DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule())
                .build()
                .inject(this)
    }
}
