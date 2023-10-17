package nl.berfelo.katas.maze_walker

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@DisplayName("Maze grid should")
@TestMethodOrder(OrderAnnotation::class)
class MazeGridTest {
    // TODO: parse grid of 1 line with start and finish accessible
    // TODO: parse grid with accessible field
    // TODO parse grid with blocked field
    // TODO: parse grid of 2 lines

    @Test
    @Order(1)
    @DisplayName("fail to parse grid without Start")
    fun rejectParsingGridWithoutStart() {
        val grid = ""
        assertThatThrownBy { parseGrid(grid) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Maze should have a start position set.")
    }

    @Test
    @Order(2)
    @DisplayName("fail to parse grid without Finish")
    fun rejectParsingGridWithoutFinish() {
        val grid = "S"
        assertThatThrownBy { parseGrid(grid) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Maze should have a finish position set.")
    }

    @Test
    @Order(3)
    @DisplayName("parse grid of 1 line with start and finish")
    fun acceptParsingGridWithStartAndFinish() {
        val grid = "S F"
        assertThat(parseGrid(grid))
                .isInstanceOf(MazeGrid::class.java)
                .hasFieldOrProperty("start")
                .hasFieldOrProperty("finish")
    }

    @Test
    @Order(4)
    @DisplayName("parse grid of 1 line with start and finish positioned")
    fun acceptParsingGridWithPositionedStartAndFinish() {
        val grid = "S F"
        assertThat(parseGrid(grid))
                .isInstanceOf(MazeGrid::class.java)
                .hasFieldOrPropertyWithValue("start", Point(0, 0))
                .hasFieldOrPropertyWithValue("finish", Point(1, 0))
    }

    @Test
    @Order(5)
    @DisplayName("parse grid of 1 line with finish and start correctly positioned")
    fun acceptGridWithPositionedFinishAndStart() {
        val grid = "F S"
        assertThat(parseGrid(grid))
                .isInstanceOf(MazeGrid::class.java)
                .hasFieldOrPropertyWithValue("start", Point(1, 0))
                .hasFieldOrPropertyWithValue("finish", Point(0, 0))
    }

    @Test
    @Order(6)
    @DisplayName("parse grid of 1 line with start and finish accessible")
    fun parseGridWithStartAndFinishAccessible() {
        val grid = "S F"
        assertThat(parseGrid(grid).maze)
            .containsExactly(listOf(true, true))
    }
}