package algorithms.sorts

import algorithms.utils.Constants.SortTypes.QUICKSORT_TEXT
import console.AsciiProgressBar.updateProgressBar
import utils.Constants.EMPTY_STRING
import utils.Constants.ONE
import utils.Constants.ZERO
import utils.Utils
import utils.Utils.swapIndexes
import java.time.LocalDateTime

object QuickSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = QUICKSORT_TEXT

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultQuickSort(arraySize_, lowestValue_, highestValue_)
            val durationText: String = if (runNum + ONE == numRun_) getDuration()
            else EMPTY_STRING
            updateProgressBar(runNum, numRun_, durationText)
        }
    }

    private fun defaultQuickSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
        quickSort(arrayToSort, ZERO, arraySize_ - ONE)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this)
        quickSort(arrayToSort_, ZERO, (arrayToSort_.size - ONE))
        return getSortInfo()
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