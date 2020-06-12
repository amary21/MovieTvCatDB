package com.amary.app.data.moviecat.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.activity.fragment.MoviesFragment
import com.amary.app.data.moviecat.activity.fragment.TvShowFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        lateinit var fragment: Fragment
        when (menuItem.itemId) {
            R.id.nv_movie -> {
                //fragment movie
                fragment = MoviesFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_container, fragment)
                        .commit()
                supportActionBar?.setTitle(R.string.tvshow)

                return@OnNavigationItemSelectedListener true
            }
            R.id.nv_tvshow -> {
                //fragment tvshow
                fragment = TvShowFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_container, fragment)
                        .commit()
                supportActionBar?.setTitle(R.string.tvshow)

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val naviBottom = findViewById<BottomNavigationView>(R.id.bnv_layout)
        naviBottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            naviBottom.selectedItemId = R.id.nv_movie
            Objects.requireNonNull(supportActionBar)!!.setTitle(R.string.movies)
        }
    }
}