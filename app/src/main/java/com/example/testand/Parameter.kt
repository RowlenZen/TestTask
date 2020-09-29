package com.example.testand

import com.google.gson.annotations.SerializedName

class Parameter (
    @SerializedName("owner") val ownerQuestion : OwnerQuestion,
    @SerializedName("body") val body : String
)