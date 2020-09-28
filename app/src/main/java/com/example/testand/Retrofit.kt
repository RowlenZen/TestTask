package com.example.testand

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.stackexchange.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service = retrofit.create(RequestOfSearch::class.java)