package org.systers.mentorshipsystem.application

import android.app.Application

class MentorshipSystemApplication : Application() {

    companion object {
        lateinit var instance: MentorshipSystemApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}