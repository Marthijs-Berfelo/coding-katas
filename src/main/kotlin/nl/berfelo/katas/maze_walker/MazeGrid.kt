package nl.berfelo.katas.maze_walker

class MazeGrid(
    val start: Point,
    val finish: Point,
    val maze: List<List<Boolean>>
) {
    fun isFieldAccessible(accessiblePoint: Point): Boolean =
        runCatching {
            maze[accessiblePoint.y][accessiblePoint.x]
        }
            .getOrDefault(false)
}

private const val startField = "S"
private const val finishField = "F"
private const val blockedField = "#"

fun parseGrid(grid: String): MazeGrid {
    val gridElements = grid
        .split("\n")
        .map { it.split(" ") }
        .map { line -> line.map(::isFieldAccessible) }
    val start = findField(grid, startField)
    val finish = findField(grid, finishField)
    require(start.x >= 0) { "Maze should have a start position set." }
    require(finish.x >= 0) { "Maze should have a finish position set." }
    return MazeGrid(start = start, finish = finish, gridElements)
}

private fun isFieldAccessible(it: String) = it != blockedField

private fun findField(grid: String, fieldName: String): Point {
    val gridRows = grid.split("\n")
    val rowIndex = gridRows.indexOfFirst { it.contains(fieldName) }
    if (rowIndex < 0) {
        return Point(rowIndex, rowIndex)
    }
    return gridRows[rowIndex]
        .split(" ")
        .let { findField(it, fieldName, rowIndex) }
}

private fun findField(gridRow: List<String>, fieldName: String, rowIndex: Int) =
    Point(gridRow.indexOf(fieldName), rowIndex)