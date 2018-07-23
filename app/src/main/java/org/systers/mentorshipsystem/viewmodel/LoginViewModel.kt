package org.systers.mentorshipsystem.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.systers.mentorshipsystem.model.data.repositories.UsersRepository
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.response.LoginResponseData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.systers.mentorshipsystem.application.MentorshipSystemApplication
import org.systers.mentorshipsystem.model.data.remote.UsersRemoteDataSource


class LoginViewModel (app: Application) : ObservableViewModel(app) {

    // input data
    var inputUsername = ""
    var inputPassword = ""

    private var usersRepository: UsersRepository = UsersRepository(UsersRemoteDataSource())
    private val compositeDisposable = CompositeDisposable()


    fun login() {
        Log.d(TAG, "loginInvoked")

        val username = inputUsername
        val password = inputPassword


        Log.d(TAG, "Username is $username and password is $password")

        if (!areValidInputs(username, password)) return

        val loginRequestData = LoginRequestData(username, password)

        isLoading.set(true)

        val disposable: Disposable = usersRepository.loginUser(loginRequestData)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({responseData ->
                    loginResponseData.value = responseData
                    isLoading.set(false)
                    Log.d(TAG, responseData.accessToken)
                }, { error ->
                    // on error

                    Log.d(TAG, error.message)
                }, {
                    // onComplete
                    Log.d(TAG, "LALALALALAL")
                })

        compositeDisposable.add(disposable)
    }

    val showOrHideUsernameError = MutableLiveData<String>()
    val showOrHidePasswordError = MutableLiveData<String>()
    val loginResponseData = MutableLiveData<LoginResponseData>()
    val isLoading = ObservableField<Boolean>()

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

    companion object {
        const val TAG = "LoginViewModel"
    }
}
