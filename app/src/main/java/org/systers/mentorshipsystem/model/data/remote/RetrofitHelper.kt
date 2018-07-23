package org.systers.mentorshipsystem.model.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val MENTORSHIP_SYSTEM_BACKEND_BASE_URL = "http://systers-mentorship-dev.eu-central-1.elasticbeanstalk.com/"

    val httpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(MENTORSHIP_SYSTEM_BACKEND_BASE_URL)
            .client(httpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}