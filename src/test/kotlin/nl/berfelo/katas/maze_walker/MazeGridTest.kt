package nl.berfelo.katas.maze_walker

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Maze grid should")
class MazeGridTest {
    // TODO: parse grid of 1 line
    // TODO: parse grid of 2 lines
    // TODO: parse grid with accessible field
    // TODO parse grid with blocked field

    @Test
    @DisplayName("fail to parse grid without Start")
    fun rejectParsingGridWithoutStart() {
        val grid = ""
        assertThatThrownBy { parseGrid(grid) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Maze should have a start position set.")
    }

    @Test
    @DisplayName("fail to parse grid without Finish")
    fun rejectParsingGridWithoutFinish() {
        val grid = "S"
        assertThatThrownBy { parseGrid(grid) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Maze should have a finish position set.")
    }
}