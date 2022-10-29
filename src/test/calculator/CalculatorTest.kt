package calculator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CalculatorTest {

    @Test
    fun multiply2By2() {
        val calc = Calculator()
        val result = calc.parse("2 * 2")
        assertEquals(4, result)
    }

    @Test
    internal fun divide2By2() {
        val calc = Calculator()
        val result = calc.parse("2 / 2")
        assertEquals(1, result)
    }
}