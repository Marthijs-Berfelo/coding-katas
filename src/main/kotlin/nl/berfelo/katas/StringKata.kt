package nl.berfelo.katas

class StringKata {

    fun fizzBuzz(input: Int): String =
            if (input == 3) {
                "Fizz"
            } else {
                "$input"
            }
}