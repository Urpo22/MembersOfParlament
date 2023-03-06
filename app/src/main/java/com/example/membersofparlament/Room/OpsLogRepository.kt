package com.example.membersofparlament.Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.example.membersofparlament.network.membersOfParliamentApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object OpsLogRepository {
    private val dao = KansanedustajaDB.getInstance().opsLogDAO
    val logData: LiveData<List<Kansanedustaja>> = dao.getAll().asFlow().asLiveData()

     suspend fun newOpsLogEntry() {
        withContext(Dispatchers.IO){
         val membersData = membersOfParliamentApi.retrofitService.getMembersOfParliamentList()
         dao.insert(membersData.map { SingleMember ->
             Kansanedustaja(
                 hetekaId = SingleMember.hetekaId,
                 lastname = SingleMember.lastname,
                 firstname = SingleMember.firstname,
                 seatNumber = SingleMember.seatNumber,
                 party = SingleMember.party,
                 minister = SingleMember.minister,
                 pictureUrl = SingleMember.pictureUrl,

             )
     })
    }
}
}