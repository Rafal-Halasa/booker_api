package com.simcodic.books.presentation.base.data

import com.simcodic.books.domain.base.data.Output
import com.simcodic.books.domain.base.data.FailOutput
import com.simcodic.books.domain.base.data.SuccessOutput
import com.simcodic.books.presentation.base.data.ResponseStatutes.*

sealed class Response(status: ResponseStatutes) {
    val status: String

    init {
        this.status = status.name.lowercase()
    }
}

data class SuccessResponse(val data: Any) : Response(SUCCESS)
data class FailResponse(val data: Any) : Response(FAIL)
data class ErrorResponse(val message: String) : Response(ERROR)

enum class ResponseStatutes {
    SUCCESS, FAIL, ERROR
}

fun makeResponse(block: () -> Output) =
    try {
        when (val output = block()) {
            is SuccessOutput -> SuccessResponse(output.data)
            is FailOutput -> FailResponse(output.data)
        }
    } catch (exception: Exception) {
        ErrorResponse(exception.message ?: "Unknown Exception")
    }
