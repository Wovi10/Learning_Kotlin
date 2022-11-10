package algorithms.sorts

import algorithms.sorts.utils.Constants.INSERTIONSORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import consoleInteraction.AsciiProgressBar.updateProgressBar
import utils.Constants.EMPTY_STRING
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

object InsertionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = INSERTIONSORT_TEXT

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int){
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultInsertionSort(arraySize_, lowestValue_, highestValue_)
            val durationText: String = if (runNum + ONE == numRun_) getDuration()
            else EMPTY_STRING
            updateProgressBar(runNum, numRun_, durationText)
        }
    }

    private fun defaultInsertionSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowestValue_, highestValue_)
        insertionSort(arrayToSort)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this)
        insertionSort(arrayToSort_)
        return getSortInfo()
    }

    private fun insertionSort(arrayToSort_: IntArray) {
        for (i in ONE until arrayToSort_.size) {
            val numberChecking = arrayToSort_[i]
            var j = i - ONE
            while (j >= ZERO && arrayToSort_[j] > numberChecking) {
                arrayToSort_[j + ONE] = arrayToSort_[j]
                j -= ONE
            }
            arrayToSort_[j + ONE] = numberChecking
        }
    }
}