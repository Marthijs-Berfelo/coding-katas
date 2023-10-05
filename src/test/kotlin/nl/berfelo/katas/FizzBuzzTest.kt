package nl.berfelo.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Fizz Buzz should")
class FizzBuzzTest {
    // TODO: return "FizzBuzz" when input is 30

    private val kata = StringKata()

    @Test
    @DisplayName("return input as string")
    fun convertInputToText() {
        val input = 1
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("$input")
    }

    @Test
    @DisplayName("return 'Fizz' when input is 3")
    fun convertThreeToFizz() {
        val input = 3
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("Fizz")
    }
    @Test
    @DisplayName("return 'Fizz' when input is 6")
    fun convertSixToFizz() {
        val input = 6
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("Fizz")
    }
    @Test
    @DisplayName("return 'Buzz' when input is 5")
    fun convertFiveToBuzz() {
        val input = 5
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("Buzz")
    }
    @Test
    @DisplayName("return 'Buzz' when input is 10")
    fun convertTenToBuzz() {
        val input = 10
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("Buzz")
    }
    @Test
    @DisplayName("return 'FizzBuzz' when input is 15")
    fun convertFifteenToFizzBuzz() {
        val input = 15
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("FizzBuzz")
    }
}