package com.example.membersofparlament.Overview

/*
6.3.2022
Niilo Urpola
2217663
 */
// ListViewModel is used to get the data from the API and pass it to the adapter
// The data is passed to the adapter as a list
// The data is filtered by the party name that is passed from the home fragment


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.membersofparlament.Room.Kansanedustaja
import com.example.membersofparlament.Room.OpsLogRepository
import kotlinx.coroutines.launch


class ListViewModel: ViewModel(){
    private val repository = OpsLogRepository
    val LogData: LiveData<List<Kansanedustaja>> = repository.logData

    init {
        getMembersOfParliamentList()
    }

    private fun getMembersOfParliamentList() {
        viewModelScope.launch {
            repository.newOpsLogEntry()
        }
    }
}



