package com.teemodev.login_kotlinmvvmdagger2jetpack.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.AppDatabase.Companion.DB_VERSION
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.dao.LoginDAO
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.entity.LoginEntity

@Database(entities = [LoginEntity::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "test.db"
        const val DB_VERSION = 1
    }

    abstract fun loginDAO(): LoginDAO
}
