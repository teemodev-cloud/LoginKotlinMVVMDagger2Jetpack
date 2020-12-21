package com.teemodev.login_kotlinmvvmdagger2jetpack

import android.content.Context
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.component.DaggerAppComponent
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun applicationInjector() = applicationInjector
}