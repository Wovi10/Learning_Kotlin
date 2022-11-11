package algorithms.sorts

import algorithms.Algorithm
import utils.Constants.NEWLINE
import utils.Constants.TAB
import utils.Constants.ZERO
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

    protected fun getSortInfo(numTries: Int? = ZERO): String {
        var sortInfo = name + NEWLINE
        sortInfo += TAB + getDuration() + NEWLINE
        if (numTries != ZERO) sortInfo += TAB + "Took $numTries tries.$NEWLINE"
        return sortInfo
    }
}