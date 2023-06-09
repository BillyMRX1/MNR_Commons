package com.mnr.commons.instances

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitProvider(
    private val baseUrl: String,
    private val debug: Boolean,
    private val headerInterceptor: Interceptor?,
    private val chuckerInterceptor: Interceptor?
) : KoinComponent {

    private val httpLoggingInterceptor by inject<HttpLoggingInterceptor.Level>()
    private val gson = GsonConverterFactory.create()

    private val httpClient: OkHttpClient.Builder by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor(debug))
            .apply {
                chuckerInterceptor?.let { addInterceptor(it) }
                headerInterceptor?.let { addInterceptor(it) }
            }
            .also { setTimeout(it) }
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(gson)
            .baseUrl(baseUrl)
            .client(httpClient.build())
            .build()
    }

    fun request(service: Class<Any>) {
        retrofit.create(service)
    }

    private fun setTimeout(client: OkHttpClient.Builder): OkHttpClient.Builder {
        return client.connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .callTimeout(20, TimeUnit.SECONDS)
    }

    private fun loggingInterceptor(debug: Boolean) = HttpLoggingInterceptor().apply {
        level =
            if (debug) this@RetrofitProvider.httpLoggingInterceptor
            else HttpLoggingInterceptor.Level.NONE
    }
}
