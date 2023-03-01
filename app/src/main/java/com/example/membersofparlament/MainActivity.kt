package com.example.membersofparlament

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        appContext = applicationContext
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController)


    }

/*
    class MainActivityViewModel : ViewModel() {
        private val repository = OpsLogRepository
        val logData: LiveData<List<Kansanedustaja>> = repository.logData

        init {
            insertOpsLogEntry()
        }

        fun insertOpsLogEntry() {
            viewModelScope.launch {
                repository.newOpsLogEntry()
            }
        }
    }
}

*/
}
