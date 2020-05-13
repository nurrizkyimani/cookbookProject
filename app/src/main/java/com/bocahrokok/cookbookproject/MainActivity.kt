package com.bocahrokok.cookbookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()


        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.loginFragment ) {
                bottom_navigation.visibility = View.GONE
            } else {
                bottom_navigation.visibility = View.VISIBLE
            }
        }



    }


    override fun onDestroy() {
        super.onDestroy()
        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.loginFragment ) {
                bottom_navigation.visibility = View.GONE
            } else {
                bottom_navigation.visibility = View.VISIBLE
            }
        }
    }
}
