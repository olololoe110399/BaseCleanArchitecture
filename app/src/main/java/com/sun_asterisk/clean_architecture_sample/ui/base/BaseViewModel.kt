package com.sun_asterisk.clean_architecture_sample.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

internal abstract class BaseViewModel : ViewModel(), CoroutineScope, KoinComponent {

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main

    open fun create() {
    }
}
