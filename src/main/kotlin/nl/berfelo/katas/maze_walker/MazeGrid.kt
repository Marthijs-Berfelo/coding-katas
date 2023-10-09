package nl.berfelo.katas.maze_walker

import java.lang.IllegalArgumentException

class MazeGrid(
        val start: Point,
        val finish: Point
)

private const val startField = "S"
private const val finishField = "F"

fun parseGrid(grid: String): MazeGrid {
    return if (!grid.contains(startField))
        throw IllegalArgumentException("Maze should have a start position set.")
    else if (!grid.contains(finishField))
        throw IllegalArgumentException("Maze should have a finish position set.")
    else {
        val gridRow = grid.split(" ")
        MazeGrid(start = findField(gridRow, startField, 0), finish = findField(gridRow, finishField, 0))
    }
}

private fun findField(gridRow: List<String>, fieldName: String, rowIndex: Int) = Point(gridRow.indexOf(fieldName), rowIndex)