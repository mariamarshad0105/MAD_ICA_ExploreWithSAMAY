package com.example.explore_with_samay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_item_1 -> {
                    replaceFragment(Home.newInstance())
                    true
                }
                R.id.navigation_item_2 -> {
                    replaceFragment(Categories.newInstance())
                    true
                }
                R.id.navigation_item_3 -> {
                    replaceFragment(Shorts.newInstance("param1_value", "param2_value"))
                    true
                }
                R.id.navigation_item_4 -> {
                    replaceFragment(Favourites.newInstance())
                    true
                }
                R.id.navigation_item_5 -> {
                    replaceFragment(Contact.newInstance())
                    true
                }
                else -> false
            }
        }

        // Set the default fragment
        if (savedInstanceState == null) {
            replaceFragment(Home.newInstance())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
