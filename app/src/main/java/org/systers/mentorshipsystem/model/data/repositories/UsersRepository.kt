package org.systers.mentorshipsystem.model.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import org.systers.mentorshipsystem.model.response.User
import org.systers.mentorshipsystem.model.data.UsersDataSource
import org.systers.mentorshipsystem.model.data.remote.UsersRemoteDataSource
import org.systers.mentorshipsystem.model.request.LoginRequestData
import org.systers.mentorshipsystem.model.request.RegisterRequestData
import org.systers.mentorshipsystem.model.response.LoginResponseData

class UsersRepository(
        private val usersRemoteDataSource: UsersDataSource = UsersRemoteDataSource()
) : UsersDataSource {

    var cachedUsers = emptyList<User>()

    override fun loginUser(loginRequestData: LoginRequestData): Observable<LoginResponseData> {
        return usersRemoteDataSource.loginUser(loginRequestData)
    }

    override fun registerUser(registerRequestData: RegisterRequestData): Completable {
        return usersRemoteDataSource.registerUser(registerRequestData)
    }

    override fun getUsers(): Observable<List<User>> {
        return usersRemoteDataSource.getUsers()
                .doOnNext { cachedUsers = it }
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