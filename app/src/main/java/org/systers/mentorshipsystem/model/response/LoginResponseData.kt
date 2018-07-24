package org.systers.mentorshipsystem.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponseData (
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("expiry") val expiryTimestamp: Float,
    val message: String
)