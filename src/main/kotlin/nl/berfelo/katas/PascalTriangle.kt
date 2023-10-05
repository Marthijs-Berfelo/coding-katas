package nl.berfelo.katas

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PascalTriangle {
    private val log: Logger by lazy { LoggerFactory.getLogger(this::class.java) }

    fun create(rows: Long): List<List<Long>> =
            if (rows < 1L) {
                emptyList()
            } else {
                listOf(listOf(1L))
            }
                        .also { log.info("Pascal triangle with $rows rows: $it") }

}