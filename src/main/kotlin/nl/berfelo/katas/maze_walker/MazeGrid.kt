package nl.berfelo.katas.maze_walker

import java.lang.IllegalArgumentException

class MazeGrid(
        val start: Boolean,
        val finish: Boolean
)

private const val startField = "S"

fun parseGrid(grid: String): MazeGrid =
        if (!grid.contains(startField))
            throw IllegalArgumentException("Maze should have a start position set.")
        else if (!grid.contains("F"))
            throw IllegalArgumentException("Maze should have a finish position set.")
        else
            MazeGrid(start = true, finish = true)
