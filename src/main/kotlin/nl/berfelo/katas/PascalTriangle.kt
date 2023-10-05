package nl.berfelo.katas

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PascalTriangle {
    private val log: Logger by lazy { LoggerFactory.getLogger(this::class.java) }

    fun create(rows: Long): List<List<Long>> = emptyList<List<Long>>()
            .also { log.info("Pascal triangle with $rows rows: $it") }
}