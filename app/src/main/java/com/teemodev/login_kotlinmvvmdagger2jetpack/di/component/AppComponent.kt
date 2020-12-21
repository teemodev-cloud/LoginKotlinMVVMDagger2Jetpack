package com.teemodev.login_kotlinmvvmdagger2jetpack.di.component

import android.app.Application
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.builder.ActivityBuilder
import com.teemodev.login_kotlinmvvmdagger2jetpack.App
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.module.*
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication?> {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}

