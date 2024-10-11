package com.jack.logparser.service

import com.jack.logparser.api.response.ParseResult
import com.jack.logparser.entities.LogAnalysis
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStream

@Service
class ParserService {
    fun parseLogs(logFileContent: InputStream): ParseResult {
        val ipCounts = mutableMapOf<String, Int>()
        val urlCounts = mutableMapOf<String, Int>()

        try {
            BufferedReader(logFileContent.reader())
            logFileContent.bufferedReader().useLines { lines ->
                lines.forEach { line ->
                    try {
                        val ip = line.substringBefore(" ")
                        val urlRegex = """"([A-Z]+ /\S*) HTTP/[\d.]+"""".toRegex()
                        val requestMatch = urlRegex.find(line)
                        requestMatch?.let { result ->
                            val (url) = result.destructured
                            urlCounts[url] = urlCounts.getOrDefault(url, 0) + 1
                        }

                        ipCounts[ip] = ipCounts.getOrDefault(ip, 0) + 1
                    } catch (e: Exception) {
                        return ParseResult.Failure("Failed to process line: $line")
                    }
                }
            }

            return ParseResult.Success(LogAnalysis(ipCounts, urlCounts))
        } catch (e: Exception) {
            return ParseResult.Failure("Failed to parse logs")
        }
    }
}
