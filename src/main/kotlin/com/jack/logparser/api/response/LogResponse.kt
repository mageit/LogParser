package com.jack.logparser.api.response

import com.jack.logparser.entities.AnalysedResultType

sealed class ParseResult {
    data class Success(
        val result: AnalysedResultType,
    ) : ParseResult()

    data class Failure(
        val errorMessage: String,
    ) : ParseResult()
}

data class LogResponse(
    val result: AnalysedResultType,
)
