package nl.berfelo.katas

import nl.berfelo.katas.FizzBuzzUtil.oneThroughOneHundred
import nl.berfelo.katas.FizzBuzzUtil.FIZZ
import nl.berfelo.katas.FizzBuzzUtil.BUZZ
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Fizz Buzz should")
class FizzBuzzTest {

    private val kata = StringKata()

    private companion object {

        @JvmStatic
        private fun soundOff(): List<Arguments> =
                oneThroughOneHundred()
                        .map { (input, expected) -> Arguments.of(input, expected) }
    }
    @Test
    @DisplayName("return input as string")
    @Order(1)
    fun convertInputToText() {
        val input = 1
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("$input")
    }

    @Test
    @DisplayName("return 'Fizz' when input is 3")
    @Order(2)
    fun convertThreeToFizz() {
        val input = 3
        assertThat(kata.fizzBuzz(input))
                .isEqualTo(FIZZ)
    }

    @Test
    @DisplayName("return 'Fizz' when input is 6")
    @Order(3)
    fun convertSixToFizz() {
        val input = 6
        assertThat(kata.fizzBuzz(input))
                .isEqualTo(FIZZ)
    }

    @Test
    @DisplayName("return 'Buzz' when input is 5")
    @Order(4)
    fun convertFiveToBuzz() {
        val input = 5
        assertThat(kata.fizzBuzz(input))
                .isEqualTo(BUZZ)
    }

    @Test
    @DisplayName("return 'Buzz' when input is 10")
    @Order(5)
    fun convertTenToBuzz() {
        val input = 10
        assertThat(kata.fizzBuzz(input))
                .isEqualTo(BUZZ)
    }

    @Test
    @DisplayName("return 'FizzBuzz' when input is 15")
    @Order(6)
    fun convertFifteenToFizzBuzz() {
        val input = 15
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("$FIZZ$BUZZ")
    }

    @DisplayName("when sounding off")
    @ParameterizedTest(name = "sound off ({index}): {argumentsWithNames}")
    @MethodSource
    @Order(7)
    fun soundOff(input: Int, expected: String) {
       assertThat(kata.fizzBuzz(input))
               .isEqualTo(expected)
    }
}