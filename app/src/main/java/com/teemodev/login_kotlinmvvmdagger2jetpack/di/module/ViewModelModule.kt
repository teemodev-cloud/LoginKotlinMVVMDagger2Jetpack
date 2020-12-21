package com.teemodev.login_kotlinmvvmdagger2jetpack.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.scope.ViewModelKey
import com.teemodev.login_kotlinmvvmdagger2jetpack.di.scope.ApplicationScope
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.ViewModelFactory
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ApplicationScope
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun providesLoginViewModel(viewModel: LoginViewModel): ViewModel
}