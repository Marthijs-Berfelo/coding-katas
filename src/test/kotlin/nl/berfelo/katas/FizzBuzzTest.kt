package nl.berfelo.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Fizz Buzz should")
class FizzBuzzTest {
    // TODO: return input as string
    // TODO: return "Fizz" when input is divisible by 3
    // TODO: return "Buzz" when input is divisible by 5
    // TODO: return "FizzBuzz" when input is divisible by 3 and 5
    private val kata = StringKata()

    @Test
    @DisplayName("return input as string")
    fun convertInputToText() {
        val input = 0
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("$input")
    }
}