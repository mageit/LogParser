package com.jack.logparser
import com.jack.logparser.api.request.LogRequestDto
import com.jack.logparser.api.response.ParseResult
import com.jack.logparser.service.ParserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile

@SpringBootTest
@AutoConfigureMockMvc
class ParserServiceTests {
    @Autowired
    private lateinit var parserService: ParserService

    @Test
    fun `test parseLogs success scenario with both different IP addresses and URLs`() {
        val fileContent =
            """           
            168.41.191.41 - - [11/Jul/2018:17:41:30 +0200] "GET /this/page/does/not/exist/ HTTP/1.1" 404 3574 "-" "Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
            168.41.191.40 - - [09/Jul/2018:10:10:38 +0200] "GET http://example.net/blog/category/meta/ HTTP/1.1" 200 3574 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_7) AppleWebKit/534.24 (KHTML, like Gecko) RockMelt/0.9.58.494 Chrome/11.0.696.71 Safari/534.24"
            """.trimIndent().byteInputStream()

        val mockFile = MockMultipartFile("file", "logfile.log", MediaType.TEXT_PLAIN_VALUE, fileContent)

        val parseRequest = LogRequestDto(mockFile)
        val parseResult = parserService.parseLogs(parseRequest.logFile.inputStream)

        assert(parseResult is ParseResult.Success)
        val successResult = parseResult as ParseResult.Success
        assertEquals(2, successResult.result.uniqueIpCounter)
        assertEquals(2, successResult.result.topThreeActiveIPs.size)
        assertEquals(2, successResult.result.topThreeVisitedUrls.size)
    }

    @Test
    fun `test parseLogs success scenario with same IP addresses and visited different URLs`() {
        val fileContent =
            """           
            168.41.191.41 - - [11/Jul/2018:17:41:30 +0200] "GET /this/page/does/not/exist/ HTTP/1.1" 404 3574 "-" "Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
            168.41.191.41 - - [09/Jul/2018:10:10:38 +0200] "GET http://example.net/blog/category/meta/ HTTP/1.1" 200 3574 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_7) AppleWebKit/534.24 (KHTML, like Gecko) RockMelt/0.9.58.494 Chrome/11.0.696.71 Safari/534.24"
            """.trimIndent().byteInputStream()

        val mockFile = MockMultipartFile("file", "logfile.log", MediaType.TEXT_PLAIN_VALUE, fileContent)

        val parseRequest = LogRequestDto(mockFile)
        val parseResult = parserService.parseLogs(parseRequest.logFile.inputStream)

        assert(parseResult is ParseResult.Success)
        val successResult = parseResult as ParseResult.Success
        assertEquals(1, successResult.result.uniqueIpCounter)
        assertEquals(1, successResult.result.topThreeActiveIPs.size)
        assertEquals(2, successResult.result.topThreeVisitedUrls.size)
    }

    @Test
    fun `test parseLogs success scenario with different IP addresses and visited same URLs`() {
        val fileContent =
            """           
            168.41.191.41 - - [11/Jul/2018:17:41:30 +0200] "GET /this/page/does/not/exist/ HTTP/1.1" 404 3574 "-" "Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
            168.41.191.40 - - [09/Jul/2018:10:10:38 +0200] "GET /this/page/does/not/exist/ HTTP/1.1" 200 3574 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_7) AppleWebKit/534.24 (KHTML, like Gecko) RockMelt/0.9.58.494 Chrome/11.0.696.71 Safari/534.24"
            """.trimIndent().byteInputStream()

        val mockFile = MockMultipartFile("file", "logfile.log", MediaType.TEXT_PLAIN_VALUE, fileContent)

        val parseRequest = LogRequestDto(mockFile)
        val parseResult = parserService.parseLogs(parseRequest.logFile.inputStream)

        assert(parseResult is ParseResult.Success)
        val successResult = parseResult as ParseResult.Success
        assertEquals(2, successResult.result.uniqueIpCounter)
        assertEquals(2, successResult.result.topThreeActiveIPs.size)
        assertEquals(1, successResult.result.topThreeVisitedUrls.size)
    }
}
