package com.teemodev.login_kotlinmvvmdagger2jetpack.di.builder

import com.teemodev.login_kotlinmvvmdagger2jetpack.view.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): LoginActivity

}