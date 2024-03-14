package nl.berfelo.katas

/**
 * Master mind kata
 *
 * @see <a href="https://codingdojo.org/kata/Mastermind/">Master mind kata</a>
 */
class MasterMind {

    /**
     * Evaluate a guess based on a given secret
     * @param secret the secret to decode (i.e. [green, blue, red, purple])
     * @param guess the guess to evaluate (i.e. [red, blue, pink, yellow])
     *
     * @return A pair to indicate the well-placed colors and the correct but misplaced colors (i.e. (1,1) based on the example secret and guess)
     */
    fun evaluate(secret: Array<String>, guess: Array<String>): Pair<Int, Int> = 0 to 0
}