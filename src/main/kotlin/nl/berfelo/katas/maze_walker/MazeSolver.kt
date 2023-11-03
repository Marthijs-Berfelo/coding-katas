package nl.berfelo.katas.maze_walker

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MazeSolver {
    private val log: Logger by lazy { LoggerFactory.getLogger(this::class.java) }

    fun solve(grid: String) {
        val maze = parseGrid(grid)
        var walker = MazeWalker(maze)

        var solving = true

        while (solving) {
            if (walker.canMoveForward()) {
                walker = walker.moveForward()
                if (walker.canTurnLeft()) {
                    walker = walker.turnLeft()
                }
            } else {
                walker = walker.turnRight()
            }

            solving = !walker.isFinished()
        }

        log.atInfo().log { "Maze || $maze || finished: $walker" }
    }
}