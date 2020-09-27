package com.example.testand

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestOfSearch {
    @GET("/2.2/search?order=desc&sort=activity&site=stackoverflow")
    fun getAnswers(@Query("intitle") searchWord: String): Call<ResponseSearch>
}