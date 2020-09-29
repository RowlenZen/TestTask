package com.example.testand

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestOfSearch {
    @GET("/2.2/search?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(@Query("intitle") searchWord: String): Call<ResponseSearch>

    @GET("/2.2/questions/{ids}/answers?order=desc&sort=activity&site=stackoverflow")
    fun getAnswers(@Path("ids") questionId : Long) : Call<ResponseOfanswers>

    @GET("/2.2/questions/{ids}?order=desc&sort=activity&site=stackoverflow&filter=!9_bDDxJY5")
    fun getBodyOfquestion(@Path("ids") questionId: Long) : Call<ResponseOfbody>
}