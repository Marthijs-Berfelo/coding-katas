package nl.berfelo.katas

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.ObjectAssert
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Master mind should")
class MasterMindTest {

    private val masterMind = MasterMind()

    @Test
    @DisplayName("evaluate secret [blue] and guess [red] to (0,0)")
    fun evaluateSingleGuessWithoutMatchingColor() {
        val secret = arrayOf("blue")
        val guess = arrayOf("red")
        val expected = 0 to 0
        masterMind
            .evaluate(secret = secret, guess = guess)
            .let(::assertThat)
            .matchesPair(expected)

    }

    @Test
    @DisplayName("evaluate secret [blue] and guess [blue] to (1,0)")
    fun evaluateSingleCorrectColor() {
        val secret = arrayOf("blue")
        val guess = arrayOf("blue")
        val expected = 1 to 0
        masterMind
            .evaluate(secret = secret, guess = guess)
            .let(::assertThat)
            .matchesPair(expected)

    }

    @Test
    @DisplayName("evaluate secret [blue, red] and guess [blue, red] to (2,0)")
    fun evaluateMultipleCorrectColors() {
        val secret = arrayOf("blue", "red")
        val guess = arrayOf("blue", "red")
        val expected = 2 to 0
        masterMind
            .evaluate(secret = secret, guess = guess)
            .let(::assertThat)
            .matchesPair(expected)
    }

    @Test
    @DisplayName("evaluate secret [blue, red, green] and guess [blue, red, yellow] to (2,0)")
    fun evaluateMultipleCorrectColorsAndOneMismatch() {
        val secret = arrayOf("blue", "red", "green")
        val guess = arrayOf("blue", "red", "yellow")
        val expected = 2 to 0
        masterMind
            .evaluate(secret = secret, guess = guess)
            .let(::assertThat)
            .matchesPair(expected)
    }

    @Test
    @DisplayName("evaluate secret [blue, red] and guess [red, green] to (0,1)")
    fun evaluateContainingColor() {
        val secret = arrayOf("blue", "red")
        val guess = arrayOf("red", "green")
        val expected = 0 to 1
        masterMind
            .evaluate(secret = secret, guess = guess)
            .let(::assertThat)
            .matchesPair(expected)
    }

    @Test
    @DisplayName("evaluate secret [blue, red, green, yellow] and guess [red, blue, green, yellow] to (2,2)")
    fun evaluateMultipleContainingAndCorrectColors() {
        val secret = arrayOf("blue", "red", "green", "yellow")
        val guess = arrayOf("red", "blue", "green", "yellow")
        val expected = 2 to 2
        masterMind
            .evaluate(secret = secret, guess = guess)
            .let(::assertThat)
            .matchesPair(expected)
    }

    private fun ObjectAssert<Pair<Int, Int>>.matchesPair(expected: Pair<Int, Int>): ObjectAssert<Pair<Int, Int>> =
        matches(
            { (correctPlaced, _) -> correctPlaced == expected.first },
            "correctly placed expected to be: ${expected.first}"
        )
            .matches(
                { (_, correctGuessed) -> correctGuessed == expected.second },
                "correctly guessed expected to be: ${expected.second}"
            )
}