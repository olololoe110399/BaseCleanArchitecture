package com.sun_asterisk.clean_architecture_sample

import android.app.Application
import com.sun_asterisk.clean_architecture_sample.di.presentationMapperModule
import com.sun_asterisk.clean_architecture_sample.di.useCaseModule
import com.sun_asterisk.clean_architecture_sample.di.viewModelModule
import com.sun_asterisk.data.di.networkModule
import com.sun_asterisk.data.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules =
            listOf(
                repositoryModule,
                networkModule,
                presentationMapperModule,
                useCaseModule,
                viewModelModule
            )
        startKoin {
            androidLogger()
            androidContext(this@MovieApp)
            modules(modules)
        }
    }
}
