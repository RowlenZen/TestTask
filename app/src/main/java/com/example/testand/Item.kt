package com.example.testand

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("question_id") val question_id: Long,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("answer_count") val answerCount: Int,
    @SerializedName("creation_date") val creationDate: Long,
    @SerializedName("title") val title: String

)