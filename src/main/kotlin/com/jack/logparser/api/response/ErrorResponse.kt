package com.jack.logparser.api.response

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val status: HttpStatus,
    val message: String,
    val errors: Map<String, String> = emptyMap(),
)
