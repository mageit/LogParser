package com.jack.logparser.api.response

import com.jack.logparser.entities.LogAnalysis

sealed class ParseResult {
    data class Success(
        val result: LogAnalysis,
    ) : ParseResult()

    data class Failure(
        val errorMessage: String,
    ) : ParseResult()
}

data class LogResponse(
    val result: LogAnalysis,
)
