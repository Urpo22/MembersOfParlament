package com.example.membersofparlament.network
/*
6.3.2022
Niilo Urpola
2217663
 */
// Data class for the members of parliament
// The data class is used to parse the JSON data from the API

data class PMember (
    val lastname: String,
    val firstname: String,
    val hetekaId: Int,
    val seatNumber: Int,
    val party: String,
    val minister: Boolean,
    val pictureUrl: String,
    var constituency: String = "",
    var bornYear: Int = 0,
    var twitter: String = "",

    )

data class Extrat (
    val hetekaId: Int,
    val constituency: String = "",
    val bornYear: Int = 0,
    val twitter: String = "",
    )



