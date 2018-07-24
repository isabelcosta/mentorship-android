package org.systers.mentorshipsystem.model.request

import com.google.gson.annotations.SerializedName

data class RegisterRequestData (
        @SerializedName("name") val name: String,
        @SerializedName("username") val username: String,
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String,
        @SerializedName("terms_and_conditions_checked") val hasAcceptedTermsAndConditions: Boolean
)