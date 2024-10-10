package com.jack.logparser.api.request

import jakarta.validation.constraints.NotNull

data class LogRequestDto(
    @field:NotNull(message = "Log body is required")
    val logs: List<String>,
)
