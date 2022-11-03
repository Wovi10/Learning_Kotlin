package algorithms.utils

import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.ZERO
import kotlin.random.Random

object Utils {
    fun createInputArray(size_: Int, lowerBound_: Int, upperBound_: Int): IntArray {
        val outputArray = IntArray(size_)
        for (x in ZERO until size_) {
            val randomNumber = Random.nextInt(lowerBound_, upperBound_ + ONE)
            outputArray[x] = randomNumber
        }
        return outputArray
    }
}