package com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Header

data class LoginResponse(

    @SerializedName("errorCode")
    @Expose
    val errorCode: String = "",

    @SerializedName("errorMessage")
    @Expose
    val errorMessage: String = "",

    @SerializedName("user")
    @Expose
    val user: LoginModel
)
