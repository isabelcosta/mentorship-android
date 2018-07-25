package org.systers.mentorshipsystem.model.response

data class UserResponseData(
        val id: Int,
        val name: String,
        val username: String,
        val availableToMentor: Boolean,
        val needMentoring: Boolean
)