package com.jack.logparser.service

import com.jack.logparser.api.response.ParseResult
import com.jack.logparser.entities.AnalysedResultType
import com.jack.logparser.utils.Helper
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class ParserService {
    fun parseLogs(logFileContent: InputStream): ParseResult {
        val sortedIPs = mutableMapOf<String, Int>()
        val sortedUrls = mutableMapOf<String, Int>()

        try {
            logFileContent.bufferedReader().useLines { lines ->
                lines.forEach { line ->
                    try {
                        val ip = line.substringBefore(" ")
                        val urlRegex =
                            """((GET|POST|PUT|DELETE|PATCH|HEAD|OPTIONS|TRACE|CONNECT)\s+((?:https?://[^/\s]+)?/[^\s]*))(\s+HTTP/[0-9.]+)?"""
                                .toRegex()
                        val requestMatch = urlRegex.find(line)
                        requestMatch?.let { result ->
                            val (url) = result.destructured
                            sortedUrls[url] = sortedUrls.getOrDefault(url, 0) + 1
                        }

                        sortedIPs[ip] = sortedIPs.getOrDefault(ip, 0) + 1
                    } catch (e: Exception) {
                        return ParseResult.Failure("Failed to process line: $line")
                    }
                }
            }

            return ParseResult.Success(
                AnalysedResultType(
                    Helper.countTheUniqueIPsNumber(sortedIPs),
                    Helper.getTopThreeVisitedUrls(sortedUrls),
                    Helper.getTopThreeActiveIPs(sortedIPs),
                ),
            )
        } catch (e: Exception) {
            return ParseResult.Failure("Failed to parse logs")
        }
    }
}
