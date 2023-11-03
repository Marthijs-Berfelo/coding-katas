package nl.berfelo.katas.maze_walker

enum class Orientation {
    North,
    South,
    East,
    West
}

fun Orientation.left() =
    when(this) {
        Orientation.North -> Orientation.West
        Orientation.West -> Orientation.South
        Orientation.South -> Orientation.East
        Orientation.East -> Orientation.North
    }

fun Orientation.right() =
    when(this) {
        Orientation.North -> Orientation.East
        Orientation.East -> Orientation.South
        Orientation.South -> Orientation.West
        Orientation.West -> Orientation.North
    }