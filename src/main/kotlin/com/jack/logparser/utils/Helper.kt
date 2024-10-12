package com.jack.logparser.utils

object Helper {
    fun countTheUniqueIPsNumber(ipCounterMap: Map<String, Int>): Int = ipCounterMap.size

    fun getTopThreeVisitedUrls(urlCounterMap: Map<String, Int>): List<String> =
        urlCounterMap.entries
            .sortedByDescending { it.value }
            .take(3)
            .map { it.key }

    fun getTopThreeActiveIPs(ipCounterMap: Map<String, Int>): List<String> =
        ipCounterMap.entries
            .sortedByDescending { it.value }
            .take(3)
            .map { it.key }

    fun isValidIP(ip: String): Boolean {
        val ipRegex = """\b(?:\d{1,3}\.){3}\d{1,3}\b""".toRegex()
        return ipRegex.matches(ip)
    }
}
