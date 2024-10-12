package com.jack.logparser.entities

data class ParsedLogDataType(
    val ipCounts: Map<String, Int>,
    val urlCounts: Map<String, Int>,
)
