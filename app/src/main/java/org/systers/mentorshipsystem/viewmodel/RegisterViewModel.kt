package org.systers.mentorshipsystem.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.databinding.ObservableField
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.systers.mentorshipsystem.R
import org.systers.mentorshipsystem.model.data.remote.UsersRemoteDataSource
import org.systers.mentorshipsystem.model.data.repositories.UsersRepository
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.BaseResponseData
import org.systers.mentorshipsystem.model.response.LoginResponseData

class RegisterViewModel(context: Application) : ObservableViewModel(context) {

    companion object {
        const val TAG = "RegisterViewModel"
    }

    private var usersRepository: UsersRepository = UsersRepository(UsersRemoteDataSource())
    private val compositeDisposable = CompositeDisposable()

    // input data
    var inputName = ""
    var inputEmail = ""
    var inputUsername = ""
    var inputPassword = ""
    var inputConfirmPassword = ""
    var checkTermsAndConditions = false

    // LiveData objects
    val mismatchPasswordsError = MutableLiveData<String>()
    val registerResponseData = MutableLiveData<BaseResponseData>()
    val errorResponseData = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun registerUser() {

        if (isInputValid()) {

            val requestData = RegisterRequestData(
                    name = inputName,
                    username = inputUsername,
                    password = inputPassword,
                    email = inputEmail,
                    hasAcceptedTermsAndConditions = checkTermsAndConditions)

            val disposable: Disposable = usersRepository.registerUser(requestData)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({responseData ->
                        registerResponseData.value = responseData
                        isLoading.value = false
                        Log.d(TAG, responseData.message)
                    }, { error ->
                        // on error
                        Log.d(TAG, "Debbugging the error message: " + error.message)
                        isLoading.value = false
                    }, {
                        // onComplete
                        Log.d(TAG, "LALALALALAL")
                        isLoading.value = false
                    })

            compositeDisposable.add(disposable)

        }

    }

    private fun isInputValid(): Boolean {

        if (inputEmail.isBlank() || inputName.isBlank() || inputUsername.isBlank() || inputPassword.isBlank()) {
            return false
        }

        if (inputPassword != inputConfirmPassword) {
//            mismatchPasswordsError.value = context.getString(R.string.error_not_matching_passwords)
            mismatchPasswordsError.value = "Passwords are not matching!"
            return false
        } else {
            mismatchPasswordsError.value = null
        }

        return true
    }

}