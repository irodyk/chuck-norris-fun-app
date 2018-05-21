package com.yurets.chucknorrisfunapp.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.ui.abs.BaseActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.bottom_hidden_navigation_bar.*
import kotlinx.android.synthetic.main.bottom_navigation_menu.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject


class HomeActivity : BaseActivity(), HasSupportFragmentInjector {

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

        Navigation.findNavController(this, R.id.nav_host_fragment)
                .navigate(R.id.all_jokes_fragment, null)

        bottomSheetBehaviour = BottomSheetBehavior.from(bottom_navigation_root) as BottomSheetBehavior

        initListeners()

    }

    fun initListeners(){
        tv_action_category_title.setOnClickListener({
            Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.category_fragment, null)
            closeBottomNavigationMenu()
        })

        tv_action_full_list_title.setOnClickListener({
            Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.all_jokes_fragment, null)
            closeBottomNavigationMenu()
        })

        tv_action_rating_title.setOnClickListener({
            Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.action_all_jokes_fragment_to_rating_fragment, null)
            closeBottomNavigationMenu()
        })

        tv_action_favorites_title.setOnClickListener({
            Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.action_all_jokes_fragment_to_favorites_fragment, null)
            closeBottomNavigationMenu()
        })
    }

    override fun onSupportNavigateUp()
            = findNavController(R.id.nav_host_fragment).navigateUp()

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
