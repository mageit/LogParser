package com.jack.logparser.api.controller

import com.jack.logparser.api.request.LogRequestDto
import com.jack.logparser.api.response.LogResponse
import com.jack.logparser.api.response.ParseResult
import com.jack.logparser.service.ParserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class ParserController(
    private val parserService: ParserService,
) {
    @PostMapping("/parse")
    fun parseLogs(
        @Valid @ModelAttribute parseRequest: LogRequestDto,
    ): LogResponse {
        when (val parseResult = parserService.parseLogs(parseRequest.logs)) {
            is ParseResult.Success -> {
                return LogResponse(parseResult.result)
            }
            is ParseResult.Failure -> {
                throw ResponseStatusException(HttpStatus.BAD_REQUEST, parseResult.errorMessage)
            }
        }
    }

    @GetMapping("/")
    fun home(): String = "Welcome to the Log Parser API - Author: Jack Zhong"
}
