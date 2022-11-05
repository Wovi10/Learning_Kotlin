package algorithms.sorts

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.NEWLINE
import java.time.LocalDateTime

abstract class SortType : Algorithm() {
    abstract override var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int)
    abstract fun sort(arrayToSort_: IntArray)

    override fun resetVariables() {
        startTime = LocalDateTime.now()
    }

    protected fun printEndText(numRun: Int, name: String) {
        println(getCommonSection(name, numRun) + NEWLINE)
    }

    protected fun printEndText() {
        println(getDuration() + NEWLINE)
    }

    protected fun swapIndexes(arrayToSort: IntArray, indexOne: Int, indexTwo: Int) {
        val temp = arrayToSort[indexOne]
        arrayToSort[indexOne] = arrayToSort[indexTwo]
        arrayToSort[indexTwo] = temp
    }
}