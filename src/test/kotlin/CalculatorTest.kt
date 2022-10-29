import Calculator.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }

    @Test
    fun testMultiply2By2(){
        val calc = Calculator()
        val result = calc.parse("2 * 2")
        assertEquals(4, result)
    }
}