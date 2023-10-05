package nl.berfelo.katas

class StringKata {

    /**
     * Fizz buzz kata.
     *
     * @see <a href="https://tddmanifesto.com/exercises/">TDD manifesto Exercises</a>
     */
    fun fizzBuzz(input: Int): String =
            if (input % 3 == 0) {
                "Fizz"
            } else if (input == 5) {
                "Buzz"
            } else {
                input.toString()
            }
}