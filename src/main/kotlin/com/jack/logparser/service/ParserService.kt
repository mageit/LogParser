package com.jack.logparser.service

import com.jack.logparser.api.response.ParseResult
import org.springframework.stereotype.Service

@Service
class ParserService {
    fun parseLogs(logs: List<String>): ParseResult {
        try {
            logs.isNotEmpty().let {
                return ParseResult.Success(
                    mapOf(
                        "mostVisitedUrl" to "https://google.com.au",
                        "mostAccessIP" to "127.0.0.1",
                        "mostAccessTime" to "2021-09-01T00:00:00Z",
                    ),
                )
            }
        } catch (e: Exception) {
            return ParseResult.Failure("Failed to parse logs")
        }
    }
}
