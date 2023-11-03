package nl.berfelo.katas.maze_walker

data class Point(
        val x: Int,
        val y: Int
)

fun Point.forward(orientation: Orientation): Point =
        when (orientation) {
                Orientation.North -> copy(y = y - 1)
                Orientation.South -> copy(y = y + 1)
                Orientation.East -> copy(x = x + 1)
                Orientation.West -> copy(x = x - 1)
        }

fun Point.left(orientation: Orientation): Point =
        when (orientation) {
                Orientation.North -> copy(x = x - 1)
                Orientation.South -> copy(x = x + 1)
                Orientation.East -> copy(y = y - 1)
                Orientation.West -> copy(y = y + 1)
        }
