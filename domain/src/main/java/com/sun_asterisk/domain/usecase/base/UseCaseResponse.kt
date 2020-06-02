package com.sun_asterisk.domain.usecase.base

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(errorMsg: String?)
}
