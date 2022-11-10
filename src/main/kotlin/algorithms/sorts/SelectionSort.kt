package algorithms.sorts

import algorithms.sorts.utils.Constants.SELECTIONSORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import algorithms.sorts.utils.Functions.swapIndexes
import consoleInteraction.AsciiProgressBar.updateProgressBar
import utils.Constants.EMPTY_STRING
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

object SelectionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = SELECTIONSORT_TEXT

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultSelectionSort(arraySize_, lowestValue_, highestValue_)
            val durationText: String = if (runNum + ONE == numRun_) getDuration()
            else EMPTY_STRING
            updateProgressBar(runNum, numRun_, durationText)
        }
    }

    private fun defaultSelectionSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowestValue_, highestValue_)
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