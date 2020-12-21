package com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.entity.LoginEntity
import io.reactivex.Single

@Dao
interface LoginDAO : BaseDao<LoginEntity> {

    @Query("SELECT * FROM LoginTable")
    fun getLoginInfo(): LiveData<LoginEntity>
}