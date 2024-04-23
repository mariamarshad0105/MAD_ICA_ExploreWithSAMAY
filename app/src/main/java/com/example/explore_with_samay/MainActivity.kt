package com.example.explore_with_samay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_item_1 -> {
                replaceFragment(Home())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_item_2 -> {
                replaceFragment(Categories())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_item_3 -> {
                replaceFragment(Add())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_item_4 -> {
                replaceFragment(Like())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_item_5 -> {
                replaceFragment(Contact())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Initialize with the first fragment
        replaceFragment(Home())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
