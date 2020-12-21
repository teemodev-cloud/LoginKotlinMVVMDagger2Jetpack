package com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.entity.LoginEntity
import com.teemodev.login_kotlinmvvmdagger2jetpack.domain.repository.LoginRepository
import com.teemodev.login_kotlinmvvmdagger2jetpack.domain.utils.SchedulerProvider
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.base.BaseViewModel
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.model.Login
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val schedulers: SchedulerProvider
) : BaseViewModel() {
    fun login(
        username: String,
        password: String
    ): MutableLiveData<Login> {

        val loginResponse: MutableLiveData<Login> = MutableLiveData()
        val observable = repository.login(username, password)

        observable.map<Login> {
            //saveMovieDetailsRecord(it)
            it
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    loginResponse.value = it
                },
                {
                    loginResponse.value = null
                })

        return loginResponse
    }

    fun insertData(userId: String, username: String) {
        repository.insertData(userId, username)
    }

    fun getLoginDetails() : LiveData<LoginEntity>? {
        return repository.getData()
    }
}