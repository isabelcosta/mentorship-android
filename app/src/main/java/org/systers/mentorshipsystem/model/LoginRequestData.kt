package org.systers.mentorshipsystem.model

data class LoginRequestData(
        val username_or_email: String,
        val password: String
)
//        @SerializedName("username") val username_or_email,
//        @SerializedName("password") val password
