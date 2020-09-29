package com.example.testand

import com.google.gson.annotations.SerializedName

class Answer (

    @SerializedName("owner") val ownerAnswer : OwnerAnswer,
    @SerializedName("score") val score : Int,
    @SerializedName("creation_date") val creationDate : Long,
    @SerializedName("question_id") val questionId : Int,
    @SerializedName("body") val body : String

)