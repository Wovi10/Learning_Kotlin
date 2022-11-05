package algorithms.sorts

import algorithms.Algorithm
import java.time.LocalDateTime

abstract class SortType : Algorithm() {
    abstract override var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int): String
    abstract fun sort(arrayToSort_: IntArray): String

    override fun resetVariables() {
        startTime = LocalDateTime.now()
    }

    protected fun swapIndexes(arrayToSort_: IntArray, indexOne_: Int, indexTwo_: Int) {
        val temp = arrayToSort_[indexOne_]
        arrayToSort_[indexOne_] = arrayToSort_[indexTwo_]
        arrayToSort_[indexTwo_] = temp
    }
}