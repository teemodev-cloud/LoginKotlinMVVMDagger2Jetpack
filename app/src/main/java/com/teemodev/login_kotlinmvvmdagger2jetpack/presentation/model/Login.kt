package com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Login(

    val userId: String = "",

    val userName: String = "",
) : Parcelable