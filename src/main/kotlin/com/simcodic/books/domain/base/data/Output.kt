package com.simcodic.books.domain.base.data

sealed class Output(val value: Any)
data class SuccessOutput(val data: Any) : Output(data)
data class FailOutput(val data: Any) : Output(data)