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
                        .map { List(it) { 1L } }
            }
                    .also { log.info("Pascal triangle with $rows rows: $it") }

}