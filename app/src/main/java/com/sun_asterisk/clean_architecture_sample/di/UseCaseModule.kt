package com.sun_asterisk.clean_architecture_sample.di

import com.sun_asterisk.domain.usecase.GetMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetMoviesUseCase(get()) }
}