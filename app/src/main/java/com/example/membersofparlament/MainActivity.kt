package com.example.membersofparlament

/*
6.3.2022
Niilo Urpola
2217663
 */
// Main activity for the app that contains the navigation controller and the app context


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.membersofparlament.R.id.fragmentContainerView
import com.example.membersofparlament.Room.Kansanedustaja
import com.example.membersofparlament.Room.OpsLogRepository
import com.example.membersofparlament.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var appContext: Context
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        appContext = applicationContext
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
