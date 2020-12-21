package com.teemodev.login_kotlinmvvmdagger2jetpack.data.mapper

import com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.model.LoginModel
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.model.Login

object LoginMapper {

    fun transformTo(source: LoginModel): Login {
        return Login(
            userId = source.userId,
            userName = source.userName
        )
    }
}