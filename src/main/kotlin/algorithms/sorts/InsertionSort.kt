package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.TEN
import algorithms.utils.Utils
import utils.Constants.NEWLINE
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

object InsertionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = "Insertion $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int, printFreq_: Int): String {
        var printFreq = printFreq_
        if (printFreq_ > numRun_) printFreq = TEN
        startup(numRun_, name, this)
        repeat(numRun_) { runNum ->
            defaultInsertionSort(arraySize_, lowestValue_, highestValue_)
            if (runNum % printFreq == ZERO) print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        return getSortInfo(numRun_)
    }

    private fun defaultInsertionSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
        insertionSort(arrayToSort)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(ONE, name, this)
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