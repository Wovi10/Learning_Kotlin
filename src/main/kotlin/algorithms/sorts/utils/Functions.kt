package algorithms.sorts.utils

import utils.Constants
import utils.Constants.ONE
import utils.Constants.ZERO
import kotlin.random.Random

object Functions {
    fun createInputArray(size_: Int, lowerBound_: Int, upperBound_: Int): IntArray {
        val outputArray = IntArray(size_)
        for (x in ZERO until size_) {
            val randomNumber = Random.nextInt(lowerBound_, upperBound_ + ONE)
            outputArray[x] = randomNumber
        }
        return outputArray
    }

    fun swapIndexes(arrayToSort_: IntArray, indexOne_: Int, indexTwo_: Int) {
        val temp = arrayToSort_[indexOne_]
        arrayToSort_[indexOne_] = arrayToSort_[indexTwo_]
        arrayToSort_[indexTwo_] = temp
    }
}