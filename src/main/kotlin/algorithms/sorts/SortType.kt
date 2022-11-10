package algorithms.sorts

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.TEN
import utils.Constants.NEWLINE
import utils.Constants.ONE
import utils.Constants.TAB
import java.time.LocalDateTime

abstract class SortType : Algorithm() {
    abstract override var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(
        arraySize_: Int,
        lowestValue_: Int,
        highestValue_: Int,
        numRun_: Int
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