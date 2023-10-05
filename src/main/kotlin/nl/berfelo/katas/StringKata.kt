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
                        if (input % 3 == 0) {
                            it.plus("Fizz")
                        } else {
                            it
                        }
                    }
                    .let {
                        if (input % 5 == 0) {
                            it.plus("Buzz")
                        } else {
                            it
                        }
                    }
                    .ifBlank {
                            input.toString()
                        }
}