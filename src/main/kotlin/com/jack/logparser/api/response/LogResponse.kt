package com.jack.logparser.api.response

sealed class ParseResult {
    data class Success(
        val result: Map<String, String>,
    ) : ParseResult()

    data class Failure(
        val errorMessage: String,
    ) : ParseResult()
}

data class LogResponse(
    val result: Map<String, String>,
)
