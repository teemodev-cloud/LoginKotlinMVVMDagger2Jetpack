package com.teemodev.login_kotlinmvvmdagger2jetpack.di.module

import android.app.Application
import androidx.room.Room
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.scope.ApplicationScope
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.AppDatabase
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.dao.LoginDAO
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    @ApplicationScope
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration() // db will cleared when upgrade version
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideLoginDao(database: AppDatabase): LoginDAO {
        return database.loginDAO()
    }
}