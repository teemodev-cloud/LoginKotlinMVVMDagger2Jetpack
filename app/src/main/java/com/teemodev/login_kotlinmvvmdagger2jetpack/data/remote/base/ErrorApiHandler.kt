package com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.base

import com.teemodev.login_kotlinmvvmdagger2jetpack.data.remote.StatusCode.UNKNOWN_ERROR
import com.teemodev.login_kotlinmvvmdagger2jetpack.domain.exception.Failure
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException

object ErrorApiHandler {

    /**
     * Handle error from http code and wrap to single object Failure
     * @param e throwable
     * @return failure
     */
    fun handleErrorOnNext(e: Throwable): Failure {
        return if (e is HttpException) {
            val responseBody = e.response().errorBody()
            Failure(e.code(), getErrorMessage(responseBody))
        } else {
            Failure(UNKNOWN_ERROR, "Something wrong")
        }
    }

    /**
     * get error message from API
     * @param responseBody responseBody
     * @return error message
     */
    private fun getErrorMessage(responseBody: ResponseBody?): String {
        return try {
            val jsonObject = JSONObject(responseBody?.string() ?: "")
            jsonObject.getString("status_message")
        } catch (e: Exception) {
            e.message ?: "Something wrong"
        }
    }
}
