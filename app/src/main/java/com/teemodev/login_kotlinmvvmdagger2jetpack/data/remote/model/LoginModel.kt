package com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("userId")
    @Expose
    val userId: String = "",

    @SerializedName("userName")
    @Expose
    val userName: String = "",
)
