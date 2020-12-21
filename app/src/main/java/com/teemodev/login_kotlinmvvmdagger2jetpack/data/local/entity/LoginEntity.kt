package com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoginTable")
data class LoginEntity(

    val xAcc: String = "",

    val userId: String = "",

    val userName: String = ""
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = 0L

}
