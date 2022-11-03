package algorithms.utils

import kotlin.random.Random

object Utils {
    fun createInputArray(size: Int, lowerBound: Int, upperBound: Int): IntArray {
        val outputArray = IntArray(size)
        for (x in 0 until size) {
            val randomNumber = Random.nextInt(lowerBound, upperBound + 1)
            outputArray[x] = randomNumber
        }
        return outputArray
    }
}