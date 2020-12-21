package com.teemodev.login_kotlinmvvmdagger2jetpack.di.module

import android.app.Application
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.scope.ApplicationScope
import com.teemodev.login_kotlinmvvmdagger2jetpack.domain.utils.SchedulerProvider
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.AppSchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @ApplicationScope
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}