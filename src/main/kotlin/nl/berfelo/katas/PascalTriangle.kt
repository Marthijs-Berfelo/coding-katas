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
                        .map { createTriangleRow(it) }
                        .mapIndexed { index, currentRow ->
                            if (index < 1) currentRow
                            else
                                currentRow
                                        .mapIndexed { currentIndex, value ->
                                            if (currentIndex > 0 && currentIndex < currentRow.size -1)
                                                value
                                            else
                                                1L
                                        }
                        }
            }
                    .also { log.info("Pascal triangle with $rows rows: $it") }

    private fun createTriangleRow(it: Int) = List(it) { value -> value + 1L }

}