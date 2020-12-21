package com.teemodev.login_kotlinmvvmdagger2jetpack.domain.exception

data class Failure(val code: Int, val msg: String) : Throwable()
