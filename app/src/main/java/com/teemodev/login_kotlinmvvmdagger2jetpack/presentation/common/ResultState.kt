package com.example.ikara.presentation.common

import com.teemodev.login_kotlinmvvmdagger2jetpack.domain.exception.Failure

sealed class ResultState<out T> {
    class OnLoading<out T> : ResultState<T>()
    data class OnSuccess<out T>(val data: T) : ResultState<T>()
    data class OnError<out T>(val error: Failure) : ResultState<T>()
}