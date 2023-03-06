package com.example.membersofparlament.network


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



