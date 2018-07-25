package org.systers.mentorshipsystem.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.systers.mentorshipsystem.model.data.remote.UsersRemoteDataSource
import org.systers.mentorshipsystem.model.data.repositories.UsersRepository
import org.systers.mentorshipsystem.model.response.UserResponseData

class MainViewModel(context: Application) : ObservableViewModel(context) {

    companion object {
        const val TAG = "MainViewModel"
    }

    private var usersRepository: UsersRepository = UsersRepository(UsersRemoteDataSource())
    private val compositeDisposable = CompositeDisposable()

    val isLoading = MutableLiveData<Boolean>()


    fun getUsersList() {

        val disposable: Disposable = usersRepository.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({responseData ->

                    isLoading.value = false
                    Log.d(LoginViewModel.TAG, "Yasssssss")
                }, { error ->
                    // on error
                    Log.d(LoginViewModel.TAG, "lola maria"+error.message)
                    isLoading.value = false
                }, {
                    // onComplete
                    Log.d(LoginViewModel.TAG, "LALALALALAL")
                    isLoading.value = false
                })

        compositeDisposable.add(disposable)

    }



}