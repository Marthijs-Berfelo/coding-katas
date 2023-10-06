package nl.berfelo.katas

class StringKata {

    /**
     * Fizz buzz kata.
     *
     * @see <a href="https://tddmanifesto.com/exercises/">TDD manifesto Exercises</a>
     */
    fun fizzBuzz(input: Int): String =
            ""
                    .let {
                        if (input.isDivisibleBy(3)) {
                            it.plus("Fizz")
                        } else {
                            it
                        }
                    }
                    .let {
                        if (input.isDivisibleBy(5)) {
                            it.plus("Buzz")
                        } else {
                            it
                        }
                    }
                    .ifBlank {
                            input.toString()
                        }

    private fun Int.isDivisibleBy(value: Int): Boolean = this % value == 0
}