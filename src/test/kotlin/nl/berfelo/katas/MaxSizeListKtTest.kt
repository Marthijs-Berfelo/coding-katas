package nl.berfelo.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("List with max size should")
class MaxSizeListKtTest {

    private val maxSizeList = emptyList<Int>()
        .update(1)
        .update(2)
        .update(3)
        .update(4)
        .update(5)
        .update(6)
        .update(7)
        .update(8)
        .update(9)
        .update(10)

    @Test
    @DisplayName("keep ten values")
    fun keepTenValues() {
        assertThat(maxSizeList)
            .containsExactly(
                1,2,3,4,5,6,7,8,9,10
            )
    }

    @Test
    @DisplayName("keep the last 10 values on adding 11th value")
    fun keepTheLast10OnAdding11Values() {
        val result = maxSizeList
            .update(11)
        assertThat(result)
            .containsExactly(
                2,3,4,5,6,7,8,9,10,11
            )

    }
}