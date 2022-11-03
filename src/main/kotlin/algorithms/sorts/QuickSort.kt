package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import algorithms.utils.Utils
import java.time.LocalDateTime

object QuickSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Quick $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        resetVariables()
        printStartText(numRun_, name)
        repeat(numRun_){
            val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
            quickSort(arrayToSort, ZERO, arraySize_ - ONE)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        printEndText(numRun_, name)
    }

    override fun sort(arrayToSort_: IntArray) {
        resetVariables()
        printStartText(arrayToSort_, name)
        quickSort(arrayToSort_, ZERO, (arrayToSort_.size - ONE))
        printEndText()
    }

    private fun quickSort(arrayToSort_: IntArray, startIndex_: Int, numOfIndexes_: Int) {
        if (startIndex_ < numOfIndexes_) {
            val parIndex = partition(arrayToSort_, startIndex_, numOfIndexes_)
            quickSort(arrayToSort_, startIndex_, parIndex - ONE)
            quickSort(arrayToSort_, parIndex + ONE, numOfIndexes_)
        }
    }

    private fun partition(arrayToSort_: IntArray, firstIndex_: Int, lastIndex_: Int): Int {
        val pivot = arrayToSort_[lastIndex_]

        var i = firstIndex_ - ONE
        for (j in firstIndex_..lastIndex_) {
            if (arrayToSort_[j] < pivot) {
                i++
                swapIndexes(arrayToSort_, i, j)
            }
        }
        i += ONE
        swapIndexes(arrayToSort_, i, lastIndex_)
        return i
    }
}