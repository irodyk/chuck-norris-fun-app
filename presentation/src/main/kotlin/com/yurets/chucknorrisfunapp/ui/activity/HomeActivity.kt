package com.yurets.chucknorrisfunapp.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.ui.abs.BaseActivity
import com.yurets.chucknorrisfunapp.ui.fragment.FavoriteFragment
import com.yurets.chucknorrisfunapp.ui.fragment.AllJokesFragment
import com.yurets.chucknorrisfunapp.ui.fragment.RatingFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.bottom_hidden_navigation_bar.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject
import android.support.v7.widget.SearchView


class HomeActivity : BaseActivity(), HasSupportFragmentInjector, BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    private lateinit var bottomSheetBehaviour : BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        setFragment(R.id.container_main, AllJokesFragment())

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
        closeBottomNavigationMenu()
        when (item.itemId) {
            R.id.action_full_list -> setFragment(R.id.container_main, AllJokesFragment())
            R.id.action_favorites -> setFragment(R.id.container_main, FavoriteFragment())
            R.id.action_rating -> setFragment(R.id.container_main, RatingFragment())
            else -> throw IllegalArgumentException("Menu item id is invalid")
        }
        return true
    }

    fun closeBottomNavigationMenu(){
        bottomSheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = resources.getString(R.string.search_hint_search_text)

        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                setMenuItemsVisibility(menu, searchItem, false)
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                setMenuItemsVisibility(menu, searchItem, true)
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_search -> {

            }
            R.id.action_list_or_pager_view -> {

            }
            R.id.action_random_joke -> {

            }
            R.id.action_share_app -> {

            }
            R.id.action_rate_app -> {

            }
            else -> return false
        }

        return true
    }

    private fun setMenuItemsVisibility(menu: Menu, exception: MenuItem, visible: Boolean) {
        for (i in 0 until menu.size()) {
            val item = menu.getItem(i)
            if (item !== exception) item.isVisible = visible
        }
    }
}
