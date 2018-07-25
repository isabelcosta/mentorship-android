package org.systers.mentorshipsystem.model.data

import io.reactivex.Completable
import io.reactivex.Observable
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.BaseResponseData
import org.systers.mentorshipsystem.model.response.LoginResponseData
import org.systers.mentorshipsystem.model.response.UserResponseData

interface UsersDataSource {

    fun getUsers() : Observable<List<UserResponseData>>

    fun getVerifiedUsers() : Observable<List<UserResponseData>>

    fun getUser(): Observable<UserResponseData>

    fun deleteUser(): Completable

    fun loginUser(loginRequestData: LoginRequestData): Observable<LoginResponseData>

    fun registerUser(registerRequestData: RegisterRequestData): Observable<BaseResponseData>

//    fun updateUser(updateUser: UpdateUser):
}