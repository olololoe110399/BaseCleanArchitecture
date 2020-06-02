package com.sun_asterisk.data.di

import com.sun_asterisk.data.repository.MoviesRepositoryImpl
import com.sun_asterisk.domain.repository.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
}
