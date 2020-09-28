package com.example.testand

import com.google.gson.annotations.SerializedName

class Owner(

    @SerializedName("profile_image") val profileImage: String,
    @SerializedName("display_name") val displayName: String,
    @SerializedName("link") val link: String

)