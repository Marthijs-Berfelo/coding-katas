package nl.berfelo.katas

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Pascal triangle.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Pascal%27s_triangle">Pascal's Triangle</a>
 */
class PascalTriangle {
    private val log: Logger by lazy { LoggerFactory.getLogger(this::class.java) }

    fun create(rows: Int): List<List<Long>> =
            if (rows < 1) {
                emptyList()
            } else {
                (1..rows)
                        .map(::createTriangleRow)
                        .runningReduceIndexed(::calculateTriangleRowValues)
            }
                    .also {
                        log.info("Pascal triangle with $rows rows: $it")
                        it.forEach { row -> log.atDebug().log { "$row" } }
                        log.atDebug().log { "Pascal triangle completed" }
                    }

    private fun calculateTriangleRowValues(index: Int, previousRow: List<Long>, currentRow: List<Long>) =
        if (index < 1) {
            currentRow
        } else {
            List(currentRow.size) { currentIndex ->
                if (currentIndex > 0 && currentIndex < previousRow.size) {
                    previousRow[currentIndex - 1] + previousRow[currentIndex]
                } else
                    1L
            }
    }

    private fun createTriangleRow(it: Int) = List(it) { value -> value + 1L }

}