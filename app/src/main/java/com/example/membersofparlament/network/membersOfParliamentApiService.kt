package com.example.membersofparlament.network

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
}

object membersOfParliamentApi {
    val retrofitService : membersOfParliamentApiService by lazy {
        retrofit.create(membersOfParliamentApiService::class.java)
    }
}