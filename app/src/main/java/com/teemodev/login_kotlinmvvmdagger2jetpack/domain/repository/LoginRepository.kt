package com.teemodev.login_kotlinmvvmdagger2jetpack.domain.repository

import androidx.lifecycle.LiveData
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.entity.LoginEntity
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.model.LoginModel
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.model.Login
import io.reactivex.Single

interface LoginRepository {

    fun login(username: String, password: String): Single<Login>

    fun insertData(userId: String, username: String)

    fun getData() : LiveData<LoginEntity>
}
