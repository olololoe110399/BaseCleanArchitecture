package com.sun_asterisk.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sun_asterisk.data.repository.source.remote.api.MovieService
import com.sun_asterisk.data.repository.source.remote.api.ServiceGenerator
import com.sun_asterisk.shared.config.ApiConfig
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

private fun buildGson(): Gson {
    return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
}

private fun buildHttpLog(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

val networkModule = module {
    single { buildGson() }
    single {
        ServiceGenerator.generate(
            ApiConfig.BASE_URL,
            MovieService::class.java,
            get(),
            buildHttpLog()
        )
    }
}
