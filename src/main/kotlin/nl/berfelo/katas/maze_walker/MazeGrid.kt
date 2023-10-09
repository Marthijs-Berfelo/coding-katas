package nl.berfelo.katas.maze_walker

import java.lang.IllegalArgumentException

class MazeGrid(
        val start: Point,
        val finish: Point
)

private const val startField = "S"
private const val finishField = "F"

fun parseGrid(grid: String): MazeGrid {
    val gridRow = grid.split(" ")
    val start = findField(gridRow, startField, 0)
    val finish = findField(gridRow, finishField, 0)
    if (start.x < 0)
        throw IllegalArgumentException("Maze should have a start position set.")
    if (finish.x < 0)
        throw IllegalArgumentException("Maze should have a finish position set.")
    return MazeGrid(start = start, finish = finish)
}

private fun findField(gridRow: List<String>, fieldName: String, rowIndex: Int) = Point(gridRow.indexOf(fieldName), rowIndex)