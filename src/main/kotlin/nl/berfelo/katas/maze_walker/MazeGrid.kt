package nl.berfelo.katas.maze_walker

import java.lang.IllegalArgumentException

class MazeGrid(
        val grid: Array<Array<Boolean>>,
        val start: Point,
        val finish: Point
)

fun parseGrid(grid: String): MazeGrid = throw IllegalArgumentException("Maze should have a start position set.")