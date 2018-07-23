package org.systers.mentorshipsystem.model.data.remote

import io.reactivex.Completable
import io.reactivex.Observable
import org.systers.mentorshipsystem.model.data.UsersDataSource
import org.systers.mentorshipsystem.model.data.remote.services.UsersService
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.LoginResponseData
import org.systers.mentorshipsystem.model.response.User

class UsersRemoteDataSource : UsersDataSource {

    private val service by lazy {
        UsersService.create()
    }

    override fun loginUser(loginRequestData: LoginRequestData): Observable<LoginResponseData> {
        return service.loginUser(loginRequestData)
    }

    override fun registerUser(registerRequestData: RegisterRequestData): Completable {
        return service.registerUser(registerRequestData)
    }

    override fun getUsers(): Observable<List<User>> {
        return service.getUsers()
    }

    override fun getVerifiedUsers(): Observable<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}