package nl.berfelo.katas.maze_walker

import java.lang.IllegalArgumentException

class MazeGrid(
        val grid: Array<Array<Boolean>>,
        val start: Point,
        val finish: Point
)

private const val startField = "S"

fun parseGrid(grid: String): MazeGrid =
        if (!grid.contains(startField))
            throw IllegalArgumentException("Maze should have a start position set.")
        else
            throw IllegalArgumentException("Maze should have a finish position set.")

