package algorithms.sorts

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RadixSortTest {

    @Test
    fun getNumDigits() {
        val result = RadixSort.getNumDigits(500)
        assertEquals(3, result)
    }
}