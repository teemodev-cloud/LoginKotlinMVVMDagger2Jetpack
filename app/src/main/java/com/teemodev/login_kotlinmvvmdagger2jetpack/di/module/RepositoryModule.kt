package com.teemodev.login_kotlinmvvmdagger2jetpack.di.module

import com.teemodev.login_kotlinmvvmdagger2jetpack.di.scope.ApplicationScope
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.api.LoginAPI
import com.teemodev.login_kotlinmvvmdagger2jetpack.domain.repository.LoginRepository
import com.teemodev.login_kotlinmvvmdagger2jetpack.domain.repository.LoginRepositoryImpl
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @ApplicationScope
    fun provideLoginRepository(service: LoginAPI, database: AppDatabase): LoginRepository {
        return LoginRepositoryImpl(service, database);
    }
}
