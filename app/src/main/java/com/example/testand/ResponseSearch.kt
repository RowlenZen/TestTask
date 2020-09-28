package com.example.testand

import com.google.gson.annotations.SerializedName

data class ResponseSearch(
    @SerializedName("items") val item: List<Item>
)