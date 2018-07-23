package org.systers.mentorshipsystem.model.data

import io.reactivex.Completable
import io.reactivex.Observable
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.LoginResponseData
import org.systers.mentorshipsystem.model.response.User

interface UsersDataSource {

    fun getUsers() : Observable<List<User>>

    fun getVerifiedUsers() : Observable<List<User>>

    fun getUser(): Observable<User>

    fun deleteUser(): Completable

    fun loginUser(loginRequestData: LoginRequestData): Observable<LoginResponseData>

    fun registerUser(registerRequestData: RegisterRequestData): Completable

//    fun updateUser(updateUser: UpdateUser):
}