package org.systers.mentorshipsystem.model.data.remote.services

import io.reactivex.Completable
import io.reactivex.Observable
import org.systers.mentorshipsystem.model.data.remote.RetrofitHelper
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.LoginResponseData
import org.systers.mentorshipsystem.model.response.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersService {

    companion object {
        fun create() = RetrofitHelper.retrofit.create(UsersService::class.java)!!
    }

    @POST("login")
    fun loginUser(@Body loginRequestData: LoginRequestData) : Observable<LoginResponseData>

    @POST("register")
    fun registerUser(@Body registerRequestData: RegisterRequestData) : Completable

    @GET("users")
    fun getUsers() : Observable<List<User>>

}