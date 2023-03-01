package com.example.membersofparlament.Overview


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



