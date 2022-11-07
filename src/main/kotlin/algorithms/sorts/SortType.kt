package algorithms.sorts

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.TAB
import algorithms.utils.AlgorithmConstants.TEN
import java.time.LocalDateTime

abstract class SortType : Algorithm() {
    abstract override var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(
        arraySize_: Int,
        lowestValue_: Int,
        highestValue_: Int,
        numRun_: Int,
        printFreq_: Int = TEN
    ): String

    abstract fun sort(arrayToSort_: IntArray): String

    override fun resetVariables() {
        startTime = LocalDateTime.now()
    }

    protected fun getSortInfo(numRun_: Int = ONE): String {
        var sortInfo = name + NEWLINE
        sortInfo += TAB
        sortInfo += if (numRun_ != ONE) {
            "Ran $numRun_ times. $NEWLINE"
        } else {
            "Ran once. $NEWLINE"
        }
        sortInfo += TAB + getDuration() + NEWLINE
        return sortInfo
    }
}