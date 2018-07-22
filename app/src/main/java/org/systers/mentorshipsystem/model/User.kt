package org.systers.mentorshipsystem.model

data class User(
        val id: Int,
        val name: String,
        val username: String,
        val availableToMentor: Boolean,
        val needMentoring: Boolean
)