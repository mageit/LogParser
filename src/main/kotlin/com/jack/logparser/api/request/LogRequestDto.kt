package com.jack.logparser.api.request

import jakarta.validation.constraints.NotNull
import org.springframework.web.multipart.MultipartFile

data class LogRequestDto(
    @field:NotNull(message = "Log file is required")
    val logFile: MultipartFile,
)
