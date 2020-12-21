package com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.api

import com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.model.LoginResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query


interface LoginAPI {

    @POST("login")
    fun login(
        @Header("username") username: String,
        @Header("password") password: String
    ): Single<Response<LoginResponse>>
}
