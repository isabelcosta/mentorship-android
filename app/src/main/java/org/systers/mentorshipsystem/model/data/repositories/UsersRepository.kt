package org.systers.mentorshipsystem.model.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import org.systers.mentorshipsystem.model.response.UserResponseData
import org.systers.mentorshipsystem.model.data.UsersDataSource
import org.systers.mentorshipsystem.model.data.remote.UsersRemoteDataSource
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.BaseResponseData
import org.systers.mentorshipsystem.model.response.LoginResponseData

class UsersRepository(
        private val usersRemoteDataSource: UsersDataSource = UsersRemoteDataSource()
) : UsersDataSource {

    var cachedUsers = emptyList<UserResponseData>()

    override fun loginUser(loginRequestData: LoginRequestData): Observable<LoginResponseData> {
        return usersRemoteDataSource.loginUser(loginRequestData)
    }

    override fun registerUser(registerRequestData: RegisterRequestData): Observable<BaseResponseData> {
        return usersRemoteDataSource.registerUser(registerRequestData)
    }

    override fun getUsers(): Observable<List<UserResponseData>> {
        return usersRemoteDataSource.getUsers()
                .doOnNext { cachedUsers = it }
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