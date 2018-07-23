package org.systers.mentorshipsystem.model.request

import com.google.gson.annotations.SerializedName

data class LoginRequestData(
        @SerializedName("username") val usernameOrEmail: String,
        @SerializedName("password") val password: String
)
