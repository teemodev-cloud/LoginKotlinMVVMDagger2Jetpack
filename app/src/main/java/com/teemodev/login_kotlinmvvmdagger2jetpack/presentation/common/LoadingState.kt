package com.example.ikara.presentation.common

sealed class LoadingState {
    object OnLoading : LoadingState()
    object OnFinish : LoadingState()
    data class OnError(val code: Int) : LoadingState()
}