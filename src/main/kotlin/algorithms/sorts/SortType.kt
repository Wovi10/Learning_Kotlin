package algorithms.sorts

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.TAB
import java.time.LocalDateTime

abstract class SortType : Algorithm() {
    abstract override var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int, printFreq_: Int): String
    abstract fun sort(arrayToSort_: IntArray): String

    override fun resetVariables() {
        startTime = LocalDateTime.now()
    }

    protected fun getSortInfo(numRun_: Int): String {
        var sortInfo = name + NEWLINE
        sortInfo += TAB + "Ran $numRun_ times. $NEWLINE"
        sortInfo += TAB + getDuration() + NEWLINE
        return sortInfo
    }

    protected fun getSortInfo(): String {
        var sortInfo = name + NEWLINE
        sortInfo += TAB + "Ran once. $NEWLINE"
        sortInfo += TAB + getDuration() + NEWLINE
        return sortInfo
    }

    protected fun swapIndexes(arrayToSort_: IntArray, indexOne_: Int, indexTwo_: Int) {
        val temp = arrayToSort_[indexOne_]
        arrayToSort_[indexOne_] = arrayToSort_[indexTwo_]
        arrayToSort_[indexTwo_] = temp
    }
}