package com.sun_asterisk.clean_architecture_sample.di

import com.sun_asterisk.clean_architecture_sample.ui.movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * You can create your ViewModel with scope, however it is not required because
 * 1 ViewModel can be used by several LifeCycleOwners.
 */
val viewModelModule = module {
    viewModel {
        MoviesViewModel(get(), get())
    }
}
