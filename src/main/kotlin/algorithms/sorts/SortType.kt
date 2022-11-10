package algorithms.sorts

import algorithms.Algorithm
import utils.Constants.NEWLINE
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
    )

    abstract fun sort(arrayToSort_: IntArray): String

    override fun resetVariables() {
        startTime = LocalDateTime.now()
    }

    protected fun getSortInfo(): String {
        var sortInfo = name + NEWLINE
        sortInfo += TAB + getDuration() + NEWLINE
        return sortInfo
    }
}