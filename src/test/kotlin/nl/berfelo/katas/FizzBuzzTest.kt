package nl.berfelo.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Fizz Buzz should")
class FizzBuzzTest {

    private val kata = StringKata()

    private companion object {
        private const val FIZZ = "Fizz"
        private const val BUZZ = "Buzz"

        @JvmStatic
        private fun soundOff(): List<Arguments> =
                listOf(
                        1 to "1",
                        2 to "2",
                        3 to FIZZ,
                        4 to "4",
                        5 to BUZZ,
                        6 to FIZZ,
                        7 to "7",
                        8 to "8",
                        9 to FIZZ,
                        10 to BUZZ,
                        11 to "11",
                        12 to FIZZ,
                        13 to "13",
                        14 to "14",
                        15 to "$FIZZ$BUZZ",
                        16 to "16",
                        17 to "17",
                        18 to FIZZ,
                        19 to "19",
                         20 to BUZZ,
                        21 to FIZZ,
                        22 to "22",
                        23 to "23",
                        24 to FIZZ,
                        25 to BUZZ,
                        26 to "26",
                        27 to FIZZ,
                        28 to "28",
                        29 to "29",
                        30 to "$FIZZ$BUZZ",
                        31 to "31",
                        32 to "32",
                        33 to FIZZ,
                        34 to "34",
                        35 to BUZZ,
                        36 to FIZZ,
                        37 to "37",
                        38 to "38",
                        39 to FIZZ,
                        40 to BUZZ,
                        41 to "41",
                        42 to FIZZ,
                        43 to "43",
                        44 to "44",
                        45 to "$FIZZ$BUZZ",
                        46 to "46",
                        47 to "47",
                        48 to FIZZ,
                        49 to "49",
                        50 to BUZZ,
                        51 to FIZZ,
                        52 to "52",
                        53 to "53",
                        54 to FIZZ,
                        55 to BUZZ,
                        56 to "56",
                        57 to FIZZ,
                        58 to "58",
                        59 to "59",
                        60 to "$FIZZ$BUZZ",
                        61 to "61",
                        62 to "62",
                        63 to FIZZ,
                        64 to "64",
                        65 to BUZZ,
                        66 to FIZZ,
                        67 to "67",
                        68 to "68",
                        69 to FIZZ,
                        70 to BUZZ,
                        71 to "71",
                        72 to FIZZ,
                        73 to "73",
                        74 to "74",
                        75 to "$FIZZ$BUZZ",
                        76 to "76",
                        77 to "77",
                        78 to FIZZ,
                        79 to "79",
                        80 to BUZZ,
                        81 to FIZZ,
                        82 to "82",
                        83 to "83",
                        84 to FIZZ,
                        85 to BUZZ,
                        86 to "86",
                        87 to FIZZ,
                        90 to "$FIZZ$BUZZ",
                        91 to "91",
                        92 to "92",
                        93 to FIZZ,
                        94 to "94",
                        95 to BUZZ,
                        96 to FIZZ,
                        97 to "97",
                        98 to "98",
                        99 to FIZZ,
                        100 to BUZZ
                )
                        .map { (input, expected) -> Arguments.of(input, expected) }
    }
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
                .isEqualTo(FIZZ)
    }

    @Test
    @DisplayName("return 'Fizz' when input is 6")
    fun convertSixToFizz() {
        val input = 6
        assertThat(kata.fizzBuzz(input))
                .isEqualTo(FIZZ)
    }

    @Test
    @DisplayName("return 'Buzz' when input is 5")
    fun convertFiveToBuzz() {
        val input = 5
        assertThat(kata.fizzBuzz(input))
                .isEqualTo(BUZZ)
    }

    @Test
    @DisplayName("return 'Buzz' when input is 10")
    fun convertTenToBuzz() {
        val input = 10
        assertThat(kata.fizzBuzz(input))
                .isEqualTo(BUZZ)
    }

    @Test
    @DisplayName("return 'FizzBuzz' when input is 15")
    fun convertFifteenToFizzBuzz() {
        val input = 15
        assertThat(kata.fizzBuzz(input))
                .isEqualTo("$FIZZ$BUZZ")
    }

    @ParameterizedTest
    @MethodSource
    fun soundOff(input: Int, expected: String) {
       assertThat(kata.fizzBuzz(input))
               .isEqualTo(expected)
    }
}