package com.sun_asterisk.data.repository.source.remote.api

import com.google.gson.Gson
import com.sun_asterisk.data.BuildConfig.API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {

    private const val CONNECT_TIMEOUT = 60000L
    private const val READ_TIMEOUT = 20000L
    private const val WRITE_TIMEOUT = 30000L

    fun <T> generate(
        baseUrl: String,
        serviceClass: Class<T>,
        gson: Gson,
        vararg interceptors: Interceptor
    ): T {
        val okHttpBuilder = OkHttpClient().newBuilder()
        for (itr in interceptors) {
            okHttpBuilder.addInterceptor(itr)
        }
        okHttpBuilder.addInterceptor(Interceptor { chain ->
            chain.proceed(buildRequest(chain))
        })
        okHttpBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpBuilder.build())
            .build()
        return retrofit.create(serviceClass)
    }

    private fun buildRequest(chain: Interceptor.Chain) = chain.request()
        .newBuilder()
        .url(addApiKey(chain))
        .build()

    private fun addApiKey(chain: Interceptor.Chain) = chain.request().url
        .newBuilder()
        .addQueryParameter("api_key", API_KEY)
        .build()
}
