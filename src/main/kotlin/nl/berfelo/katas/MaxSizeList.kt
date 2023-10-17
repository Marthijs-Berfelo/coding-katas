package nl.berfelo.katas

val maxSize = 10
fun List<Int>.update(value: Int) =
    this.plus(value)
        .let {
            if (it.size > maxSize)
                it.drop(1)
            else
                it
        }