package com.example.testand

import com.google.gson.annotations.SerializedName

class ResponseOfbody(
    @SerializedName("items") val parameters: List<Parameter>
)