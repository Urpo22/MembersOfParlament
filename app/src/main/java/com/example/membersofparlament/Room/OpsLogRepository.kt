package com.example.membersofparlament.Room

/*
6.3.2022
Niilo Urpola
2217663
 */
// KananedustajaDB is the database for the app that contains the DAO
// The database is used to store the data from the API


import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.example.membersofparlament.network.PMember
import com.example.membersofparlament.network.membersOfParliamentApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object OpsLogRepository {
    private val dao = KansanedustajaDB.getInstance().opsLogDAO
    val logData: LiveData<List<Kansanedustaja>> = dao.getAll().asFlow().asLiveData()

     suspend fun newOpsLogEntry() {
        withContext(Dispatchers.IO){
         val membersData = membersOfParliamentApi.retrofitService.getMembersOfParliamentList()
            val extras = membersOfParliamentApi.retrofitService.getExtras().sortedBy { it.hetekaId }

            // Luodaan lisätiedoista Map-objekti hetekaId:n avulla.
            val extrasMap = extras.associateBy { it.hetekaId }

            // Käydään jäsenet läpi ja lisätään lisätietoa jos saatavilla extra-listasta Map-objektin avulla.
            for (PMember in membersData) {
                extrasMap[PMember.hetekaId]?.let { extra ->
                    PMember.constituency = extra.constituency
                    PMember.bornYear = extra.bornYear
                    PMember.twitter = extra.twitter
                }
            }
         dao.insert(membersData.map { SingleMember ->
             Kansanedustaja(
                 hetekaId = SingleMember.hetekaId,
                 lastname = SingleMember.lastname,
                 firstname = SingleMember.firstname,
                 seatNumber = SingleMember.seatNumber,
                 party = SingleMember.party,
                 minister = SingleMember.minister,
                 pictureUrl = SingleMember.pictureUrl,
                    constituency = SingleMember.constituency,
                    bornYear = SingleMember.bornYear,
                    twitter = SingleMember.twitter,
             )
     })
    }
}
}