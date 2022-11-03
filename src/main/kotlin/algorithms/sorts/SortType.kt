package algorithms.sorts

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.NEWLINE
import java.time.LocalDateTime

abstract class SortType : Algorithm() {
    abstract override var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(arraySize_: Int, lowestValue: Int, highestValue: Int, numRun: Int)
    abstract fun sort(arrayToSort_: IntArray)

    protected fun printEndText(numRun: Int, name: String) {
        println(getCommonSection(name, numRun) + NEWLINE)
    }

    protected fun printEndText(arrayToSort_: IntArray) {
        println(getDuration() + NEWLINE)
    }

    protected fun swapIndexes(arrayToSort: IntArray, i: Int, smallestIndex: Int) {
        val temp = arrayToSort[i]
        arrayToSort[i] = arrayToSort[smallestIndex]
        arrayToSort[smallestIndex] = temp
    }

    override fun resetVariables() {
        startTime = LocalDateTime.now()
    }
}