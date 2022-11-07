package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.TEN
import algorithms.utils.AlgorithmConstants.ZERO
import algorithms.utils.Utils
import java.time.LocalDateTime

object SelectionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Selection $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int, printFreq_: Int): String {
        var printFreq = printFreq_
        if (printFreq_ > numRun_) printFreq = TEN
        startup(numRun_, name, this)
        repeat(numRun_) { runNum ->
            defaultSelectionSort(arraySize_, lowestValue_, highestValue_)
            if (runNum % printFreq == ZERO) print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        return getSortInfo(numRun_)
    }

    private fun defaultSelectionSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
        selectionSort(arrayToSort)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(ONE, name, this)
        selectionSort(arrayToSort_)
        return getSortInfo()
    }

    private fun selectionSort(arrayToSort_: IntArray) {
        var smallestIndex: Int
        val arraySize: Int = arrayToSort_.size
        for (i in ZERO..arraySize) {
            smallestIndex = i
            for (j in i until arraySize) {
                if (arrayToSort_[j] < arrayToSort_[smallestIndex]) smallestIndex = j
            }
            if (smallestIndex != i) swapIndexes(arrayToSort_, i, smallestIndex)
        }
    }
}