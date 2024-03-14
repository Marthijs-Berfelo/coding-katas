package nl.berfelo.katas

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.ObjectAssert
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Master mind should")
class MasterMindTest {
    //TODO evaluate secret [blue, red] and guess [blue, red] to (2,0)
    //TODO evaluate secret [blue, red, green] and guess [blue, red, green] to (3,0)
    //TODO evaluate secret [blue, red] and guess [red, green] to (0,1)
    //TODO evaluate secret [blue, red] and guess [red, blue] to (0,2)
    //TODO evaluate secret [blue, red, green] and guess [red, green, blue] to (0,3)

    private val masterMind = MasterMind()

    @Test
    @DisplayName("evaluate secret [blue] and guess [red] to (0,0)")
    fun evaluateSingleGuessWithoutMatchingColor() {
        val secret = arrayOf("blue")
        val guess = arrayOf("red")
        val expected = 0 to 0
        assertThat(masterMind.evaluate(secret = secret, guess = guess))
            .matchesPair(expected)
    }

    @Test
    @DisplayName("evaluate secret [blue] and guess [blue] to (1,0)")
    fun evaluateSingleCorrectColor() {
        val secret = arrayOf("blue")
        val guess = arrayOf("blue")
        val expected = 1 to 0
        assertThat(masterMind.evaluate(secret = secret, guess = guess))
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