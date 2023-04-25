package com.mnr.commons.extensions

import com.mnr.commons.wrapper.ResponseResult
import retrofit2.Response
import timber.log.Timber

inline fun <reified T : Any> Response<T>.getResponseResult(): ResponseResult<T> {
    return try {
        if (this.isSuccessful) {
            Timber.d("Success response ${T::class.java} $this")
            ResponseResult.Success(this.body()!!)
        } else {
            Timber.e("Fail response ${T::class.java} ${this.message()}")
            ResponseResult.Error(
                "Fail response ${T::class.java} ${this.message()}"
            )
        }
    } catch (exception: Exception) {
        ResponseResult.Error(exception.message.toString())
    }
}