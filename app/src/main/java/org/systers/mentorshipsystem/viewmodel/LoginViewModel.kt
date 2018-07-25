package org.systers.mentorshipsystem.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.systers.mentorshipsystem.model.data.repositories.UsersRepository
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.response.LoginResponseData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.systers.mentorshipsystem.application.MentorshipSystemApplication
import org.systers.mentorshipsystem.model.data.remote.UsersRemoteDataSource
import org.systers.mentorshipsystem.util.EventWrapper
import org.systers.mentorshipsystem.view.RegisterActivity


class LoginViewModel(context: Application) : ObservableViewModel(context) {

    companion object {
        const val TAG = "LoginViewModel"
    }

    // input data
    var inputUsername = ""
    var inputPassword = ""

    // LiveData
    private val _navigateToRegistration = MutableLiveData<EventWrapper<Boolean>>()
    val showOrHideUsernameError = MutableLiveData<String>()
    val showOrHidePasswordError = MutableLiveData<String>()
    val loginResponseData = MutableLiveData<LoginResponseData>()
    val errorResponseData = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    private var usersRepository: UsersRepository = UsersRepository(UsersRemoteDataSource())
    private val compositeDisposable = CompositeDisposable()

    fun login() {
        Log.d(TAG, "loginInvoked")

        val username = inputUsername
        val password = inputPassword


        Log.d(TAG, "Username is $username and password is $password")

        if (!areValidInputs(username, password)) return

        val loginRequestData = LoginRequestData(username, password)

        isLoading.value = true

        val disposable: Disposable = usersRepository.loginUser(loginRequestData)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({responseData ->

                    loginResponseData.value = responseData
                    isLoading.value = false
                    Log.d(TAG, responseData.accessToken)
                }, { error ->
                    // on error
                    Log.d(TAG, "lola maria"+error.message)
                    isLoading.value = false
                }, {
                    // onComplete
                    Log.d(TAG, "LALALALALAL")
                    isLoading.value = false
                })

        compositeDisposable.add(disposable)
    }

    val navigateToRegistration : LiveData<EventWrapper<Boolean>>
        get() = _navigateToRegistration


    fun goToRegisterScreen() {
        _navigateToRegistration.value = EventWrapper(true)
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
