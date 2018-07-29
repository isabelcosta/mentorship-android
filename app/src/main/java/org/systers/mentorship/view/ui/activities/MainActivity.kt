package org.systers.mentorship.view.ui.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import org.systers.mentorship.R
import org.systers.mentorship.utils.BottomNavigationViewHelper
import org.systers.mentorship.utils.replaceFragmentInActivity
import org.systers.mentorship.view.ui.fragments.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                message.setText(R.string.navigation_title_home)
                replaceFragmentInActivity(HomeFragment.newInstance(), R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
//                message.setText(R.string.navigation_title_profile)
                replaceFragmentInActivity(ProfileFragment.newInstance(), R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_relation -> {
//                message.setText(R.string.navigation_title_relation)
                replaceFragmentInActivity(RelationFragment.newInstance(), R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_members -> {
//                message.setText(R.string.navigation_title_members)
                replaceFragmentInActivity(MembersFragment.newInstance(), R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_requests -> {
//                message.setText(R.string.navigation_title_requests)
                replaceFragmentInActivity(RequestsFragment.newInstance(), R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationViewHelper.disableShiftMode(bottomNavigation)

        replaceFragmentInActivity(HomeFragment.newInstance(), R.id.contentFrame)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.popup, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                R.id.menu_settings -> {

                    true
                }
                R.id.menu_about -> {

                    true
                }
                R.id.menu_feedback -> {

                    true
                }
                else -> false
            }
}
