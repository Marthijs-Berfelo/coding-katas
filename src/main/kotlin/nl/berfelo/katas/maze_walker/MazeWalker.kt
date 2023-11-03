package nl.berfelo.katas.maze_walker

import org.slf4j.Logger
import org.slf4j.LoggerFactory

data class MazeWalker(
    private val maze: MazeGrid,
    private val direction: Orientation = Orientation.South,
    val currentPosition: Point = maze.start
    ) {

    private val log: Logger by lazy { LoggerFactory.getLogger(this::class.java) }

    fun canTurnLeft(): Boolean =
        currentPosition
            .also { log.atDebug().log { "Current Position || $it | $direction" } }
            .left(direction)
            .let(maze::isFieldAccessible)
            .also { log.atDebug().log { "Current Position || $currentPosition | $direction || can turn left: $it" } }

    fun canMoveForward(): Boolean =
        currentPosition
            .also { log.atDebug().log { "Current Position || $it | $direction" } }
            .forward(direction)
            .let(maze::isFieldAccessible)
            .also { log.atDebug().log { "Current Position || $currentPosition | $direction || can move forward: $it" } }


    fun isFinished(): Boolean =
        maze.finish.x == currentPosition.x && maze.finish.y == currentPosition.y

    fun moveForward(): MazeWalker =
        also { log.atDebug().log { "Moving forward || $currentPosition || $direction" } }
            .copy(currentPosition = currentPosition.forward(direction))
            .also { log.atDebug().log { "New Position || ${it.currentPosition} || ${it.direction}" } }

    fun turnLeft(): MazeWalker =
        also { log.atDebug().log { "Turning left || $currentPosition || $direction" } }
            .copy(direction = direction.left())
            .also { log.atDebug().log { "New Position || ${it.currentPosition} || ${it.direction}" } }

    fun turnRight(): MazeWalker =
        also { log.atDebug().log { "Turning right || $currentPosition || $direction" } }
            .copy(direction = direction.right())
            .also { log.atDebug().log { "New Position || ${it.currentPosition} || ${it.direction}" } }


}