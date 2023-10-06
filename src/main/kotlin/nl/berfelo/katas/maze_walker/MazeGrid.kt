package nl.berfelo.katas.maze_walker

import java.lang.IllegalArgumentException

class MazeGrid(
        val grid: Array<Array<Boolean>>,
        val start: Point,
        val finish: Point
)

fun parseGrid(grid: String): MazeGrid =
        if (!grid.contains("S"))
            throw IllegalArgumentException("Maze should have a start position set.")
        else
            throw IllegalArgumentException("Maze should have a finish position set.")

