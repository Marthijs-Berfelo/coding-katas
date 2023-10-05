package nl.berfelo.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

@DisplayName("Pascal's triangle should")
class PascalTriangleTest {

    private val triangle = PascalTriangle()
    
    @Test
    @DisplayName("create triangle for 0 rows with result []")
    fun zeroRowsResultsInEmptyList() {
        assertThat(triangle.create(0)).isEmpty()
    }

    @Test
    @DisplayName("create triangle for 1 row with result [[1]]")
    fun singleRowTriangle() {
        assertThat(triangle.create(1))
                .containsExactly(listOf(1))
    }

    @Test
    @DisplayName("create triangle for 2 rows with result [[1],[1,1]]")
    fun twoRowsTriangle() {
        assertThat(triangle.create(2))
                .containsExactly(
                        listOf(1),
                        listOf(1,1)
                )
    }

    @Test
    @DisplayName("create triangle for 3 rows with result [[1],[1,1],[1,2,1]]")
    fun threeRowsTriangle() {
        assertThat(triangle.create(3))
                .containsExactly(
                        listOf(1),
                        listOf(1,1),
                        listOf(1,2,1),
                )
    }

    @Test
    @DisplayName("create triangle for 4 rows with result [[1],[1,1],[1,2,1],[1,3,3,1]]")
    fun fourRowsTriangle() {
        assertThat(triangle.create(4))
                .containsExactly(
                        listOf(1),
                        listOf(1,1),
                        listOf(1,2,1),
                        listOf(1,3,3,1),
                )
    }

    @Test
    @DisplayName("create triangle for 5 rows with result [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]")
    fun fiveRowsTriangle() {
        assertThat(triangle.create(5))
                .containsExactly(
                        listOf(1),
                        listOf(1,1),
                        listOf(1,2,1),
                        listOf(1,3,3,1),
                        listOf(1,4,6,4,1),
                )
    }
    @Test
    @DisplayName("create triangle for 10 rows")
    fun tenRowsTriangle() {
        assertThat(triangle.create(10))
                .containsExactly(
                        listOf(1),
                        listOf(1,1),
                        listOf(1,2,1),
                        listOf(1,3,3,1),
                        listOf(1,4,6,4,1),
                        listOf(1,5,10,10,5,1),
                        listOf(1,6,15,20,15,6,1),
                        listOf(1,7,21,35,35,21,7,1),
                        listOf(1,8,28,56,70,56,28,8,1),
                        listOf(1,9,36,84,126,126,84,36,9,1),
                )
    }

    @Test
    @DisplayName("create triangle for 500 rows within 500 milliseconds")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    fun oneHundredRowsPerformance() {
        assertThat(triangle.create(500))
                .hasSize(500)
    }
}