package algorithms.sorts

import algorithms.sorts.utils.Constants.INSERTION_SORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

object InsertionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = INSERTION_SORT_TEXT
    override var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        if (lowestValue_ > highestValue_) return
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultInsertionSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
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