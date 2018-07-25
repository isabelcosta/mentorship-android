package org.systers.mentorshipsystem.model.request

import com.google.gson.annotations.SerializedName

data class RegisterRequestData (
        val name: String,
        val username: String,
        val email: String,
        val password: String,
        @SerializedName("terms_and_conditions_checked")
        val hasAcceptedTermsAndConditions: Boolean
)