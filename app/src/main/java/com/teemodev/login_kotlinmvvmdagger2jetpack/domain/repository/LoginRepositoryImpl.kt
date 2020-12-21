package com.teemodev.login_kotlinmvvmdagger2jetpack.domain.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.AppDatabase
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.entity.LoginEntity
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.mapper.LoginMapper
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.api.LoginAPI
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.base.ErrorNetworkHandler
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.model.Login
import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val service: LoginAPI,
    private val database: AppDatabase
) : LoginRepository {

    companion object {
        var xAcc: String = ""
    }

    override fun login(username: String, password: String): Single<Login> {
        return service.login(username, password)
            .compose(ErrorNetworkHandler())
            .map {
                Log.d("HoaLT", it.headers().get("X-Acc").toString())
                xAcc = it.headers().get("X-Acc").toString()
                LoginMapper.transformTo(it.body()!!.user)
            }
    }

    override fun insertData(userId: String, username: String) {
        CoroutineScope(IO).launch {
            val loginDetail = LoginEntity(xAcc = xAcc, userId = userId, userName = username)
            database.loginDAO().insert(loginDetail)
        }
    }

    override fun getData(): LiveData<LoginEntity> {
        return database.loginDAO().getLoginInfo()
    }
}
