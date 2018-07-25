package org.systers.mentorshipsystem.application

import android.app.Application
import org.systers.mentorshipsystem.model.response.LoginResponseData

class MentorshipSystemApplication : Application() {

    companion object {
        lateinit var instance: MentorshipSystemApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    lateinit var currentUserLoginData : LoginResponseData

}