package org.systers.mentorshipsystem.model.data.remote

import io.reactivex.Completable
import io.reactivex.Observable
import org.systers.mentorshipsystem.application.MentorshipSystemApplication
import org.systers.mentorshipsystem.model.data.UsersDataSource
import org.systers.mentorshipsystem.model.data.remote.services.UsersService
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.BaseResponseData
import org.systers.mentorshipsystem.model.response.LoginResponseData
import org.systers.mentorshipsystem.model.response.UserResponseData

class UsersRemoteDataSource : UsersDataSource {

    private val service by lazy {
        UsersService.create()
    }

    private val authHeaderValue by lazy {
        val accessToken = MentorshipSystemApplication.instance.currentUserLoginData.accessToken
        "Bearer $accessToken"
    }

    override fun loginUser(loginRequestData: LoginRequestData): Observable<LoginResponseData> {
        return service.loginUser(loginRequestData)
    }

    override fun registerUser(registerRequestData: RegisterRequestData): Observable<BaseResponseData> {
        return service.registerUser(registerRequestData)
    }

    override fun getUsers(): Observable<List<UserResponseData>> {
        return service.getUsers(authHeaderValue)
    }

    override fun getVerifiedUsers(): Observable<List<UserResponseData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(): Observable<UserResponseData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}