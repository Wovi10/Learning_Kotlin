package algorithms.sorts

import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.Utils
import algorithms.utils.Utils.swapIndexes
import utils.Constants.ZERO
import utils.console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object SelectionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Selection $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int): String {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultSelectionSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
        return getSortInfo(numRun_)
    }

    private fun defaultSelectionSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
        selectionSort(arrayToSort)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this)
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