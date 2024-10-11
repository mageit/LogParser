package com.jack.logparser.entities

data class LogAnalysis(
    val ipCounts: Map<String, Int>,
    val urlCounts: Map<String, Int>,
)
