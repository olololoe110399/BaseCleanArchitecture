package com.sun_asterisk.clean_architecture_sample.model.mapper

@Suppress("unused")
abstract class PresentationMapper<T, R> {

    abstract fun map(entity: T): R
}
