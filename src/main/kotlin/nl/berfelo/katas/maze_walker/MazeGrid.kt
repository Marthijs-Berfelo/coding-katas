package nl.berfelo.katas.maze_walker

import java.lang.IllegalArgumentException

class MazeGrid(
        val start: Point,
        val finish: Point
)

private const val startField = "S"
private const val finishField = "F"

fun parseGrid(grid: String): MazeGrid =
        if (!grid.contains(startField))
            throw IllegalArgumentException("Maze should have a start position set.")
        else if (!grid.contains(finishField))
            throw IllegalArgumentException("Maze should have a finish position set.")
        else {
            val gridRow = grid.split(" ")
            MazeGrid(start = Point(gridRow.indexOf(startField), 0), finish = Point(gridRow.indexOf(finishField), 0))
        }