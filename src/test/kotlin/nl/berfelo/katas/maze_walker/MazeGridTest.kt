package nl.berfelo.katas.maze_walker

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import kotlin.math.pow
import kotlin.system.exitProcess

@DisplayName("Maze grid should")
@TestMethodOrder(OrderAnnotation::class)
class MazeGridTest {

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

    @Test
    @Order(7)
    @DisplayName("parse grid with blocked field")
    fun parseGridWithBlockedField() {
        val grid = "# S F"
        assertThat(parseGrid(grid).maze)
            .containsExactly(listOf(false, true, true))
    }

    @Test
    @Order(8)
    @DisplayName("parse grid with accessible field")
    fun parseGridWithAccessibleField() {
        val grid = "S . F"
        assertThat(parseGrid(grid).maze)
            .containsExactly(listOf(true, true, true))
    }

    @Test
    @Order(9)
    @DisplayName("parse grid of multiple lines")
    fun parseGridWithMultipleLines() {
        val grid = """
            # S
            # .
            F .
            # #
        """.trimIndent()
        assertThat(parseGrid(grid))
            .hasFieldOrPropertyWithValue("start", Point(1, 0))
            .hasFieldOrPropertyWithValue("finish", Point(0, 2))
            .hasFieldOrPropertyWithValue("maze", listOf(
                listOf(false, true),
                listOf(false, true),
                listOf(true, true),
                listOf(false, false)
            )
            )
    }

    @Test
    @Order(10)
    @DisplayName("parse maze one")
    fun parseMazeOne() {
        assertThat(parseGrid(mazeOne))
            .hasFieldOrPropertyWithValue("start", Point(1,0))
            .hasFieldOrPropertyWithValue("finish", Point(5,3))
            .hasFieldOrPropertyWithValue("maze",
                listOf(
                    listOf(false, true, false, false, false, false),
                    listOf(false, true, true, true, true, false),
                    listOf(false, false, true, false, false, false),
                    listOf(false, true, true, true, true, true),
                    listOf(false, false, false, true, false, false),
                    listOf(false, false, false, false, false, false)
                )
            )
    }

    @Test
    @Order(11)
    @DisplayName("allow access to accessible grid position")
    fun allowAccessToAccessiblePoint() {
        val grid = "S . F"
        val accessiblePoint = Point(1, 0)
        val maze = parseGrid(grid)
        assertThat(maze.isFieldAccessible(accessiblePoint)).isTrue()
    }

    @Test
    @Order(12)
    @DisplayName("reject access to blocked position")
    fun rejectAccessToBlockedPoint() {
        val grid = "# S . F"
        val accessiblePoint = Point(0, 0)
        val maze = parseGrid(grid)
        assertThat(maze.isFieldAccessible(accessiblePoint)).isFalse()
    }
    @Test
    @Order(13)
    @DisplayName("reject access to non-existent position")
    fun rejectAccessToNonExistentPoint() {
        val grid = "# S . F"
        val accessiblePoint = Point(0, 1)
        val maze = parseGrid(grid)
        assertThat(maze.isFieldAccessible(accessiblePoint)).isFalse()
    }
}