package com.sun_asterisk.clean_architecture_sample.di

import com.sun_asterisk.clean_architecture_sample.model.mapper.MovieModelMapper
import org.koin.dsl.module

val presentationMapperModule = module {
    factory { MovieModelMapper() }
}
