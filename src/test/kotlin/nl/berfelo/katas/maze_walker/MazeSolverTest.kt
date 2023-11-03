package nl.berfelo.katas.maze_walker

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder


@DisplayName("Maze solver should")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class MazeSolverTest {

    private val solver = MazeSolver()
    @Test
    fun shouldSolveMazeOne() {
        solver.solve(mazeOne)
    }

    @Test
    fun shouldSolveMazeTwo() {
        solver.solve(mazeTwo)
    }
}