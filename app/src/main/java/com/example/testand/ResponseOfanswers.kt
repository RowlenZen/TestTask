package com.example.testand

import com.google.gson.annotations.SerializedName

class ResponseOfanswers(
    @SerializedName("items") val answers: List<Answer>
)
