package org.systers.mentorshipsystem.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.util.Log

class LoginViewModel(app: Application) : ObservableViewModel(app) {

    // input data
    var inputUsername = ""
    var inputPassword = ""

    fun login() {
        Log.d(TAG, "loginInvoked")

        val username = inputUsername
        val password = inputPassword


        Log.d(TAG, "Username is $username and password is $password")

        if (areValidInputs(username, password)) return

        notifyChange()

    }

    val showOrHideUsernameError = MutableLiveData<String>()
    val showOrHidePasswordError = MutableLiveData<String>()

    fun goToRegisterScreen() {

    }

    private fun areValidInputs(username: String, password: String) : Boolean{
        var isValidInput = true

        if (username.isEmpty()) {
            showOrHideUsernameError.value = "Username cannot be empty."
            isValidInput = false
        } else {
            showOrHideUsernameError.value = null
        }

        if (password.isEmpty()) {
            showOrHidePasswordError.value = "Password cannot be empty."
            isValidInput = false
        } else {
            showOrHidePasswordError.value = null
        }

        return isValidInput
    }
}

private const val TAG = "LoginViewModel"
