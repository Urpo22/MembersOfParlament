package com.example.membersofparlament.network

/*
6.3.2022
Niilo Urpola
2217663
 */
// membersOfParliamentApiService is used to get the data from the API
// The data is parsed to the PMember data class

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://users.metropolia.fi/~peterh/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface membersOfParliamentApiService {
    @GET("seating.json")
    suspend fun getMembersOfParliamentList(): List<PMember>

    @GET("extras.json")
    suspend fun getExtras(): List<Extrat>
}

object membersOfParliamentApi {
    val retrofitService : membersOfParliamentApiService by lazy {
        retrofit.create(membersOfParliamentApiService::class.java)
    }
}