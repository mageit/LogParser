package com.jack.logparser

import com.jack.logparser.utils.Helper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureMockMvc
class HelperTests {
    @Test
    fun `test unique ip address counter within the map`() {
        val ipCounterMap =
            mapOf(
                "192.168.1.1" to 3,
                "192.168.1.2" to 5,
                "192.168.1.3" to 6,
                "192.168.1.4" to 2,
            )

        Helper.countTheUniqueIPsNumber(ipCounterMap).also {
            assert(it == 4)
        }
    }

    @Test
    fun `test a valid ip address`() {
        val ip = "192.168.1.1"
        Helper.isValidIP(ip).also {
            assert(it)
        }
    }

    @Test
    fun `test an invalid ip address`() {
        val ip = "xxx.xxx.xxx.xxx"
        Helper.isValidIP(ip).also {
            assert(!it)
        }
    }

    @Test
    fun `test top three visited urls within the map`() {
        val urlCounterMap =
            mapOf(
                "/home" to 3,
                "/about" to 5,
                "/contact" to 6,
                "/services" to 2,
            )

        Helper.getTopThreeVisitedUrls(urlCounterMap).also {
            assert(it == listOf("/contact", "/about", "/home"))
        }
    }

    @Test
    fun `test top three active ips within the map`() {
        val ipCounterMap =
            mapOf(
                "192.168.1.1" to 3,
                "192.168.1.2" to 7,
                "192.168.1.4" to 9,
                "192.168.1.5" to 4,
            )

        Helper.getTopThreeActiveIPs(ipCounterMap).also {
            assert(it == listOf("192.168.1.4", "192.168.1.2", "192.168.1.5"))
        }
    }
}
