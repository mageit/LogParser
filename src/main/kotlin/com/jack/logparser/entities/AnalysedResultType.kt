package com.jack.logparser.entities

data class AnalysedResultType(
    val uniqueIpCounter: Int,
    val topThreeVisitedUrls: List<String>,
    val topThreeActiveIPs: List<String>,
)
