package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import algorithms.utils.Utils
import java.time.LocalDateTime

object InsertionSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = "Insertion $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        resetVariables()
        printStartText(numRun_, name)
        repeat(numRun_){
            val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
            insertionSort(arrayToSort)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        printEndText(numRun_, name)
    }

    override fun sort(arrayToSort_: IntArray) {
        resetVariables()
        printStartText(arrayToSort_, name)
        insertionSort(arrayToSort_)
        printEndText()
    }

    private fun insertionSort(arrayToSort_: IntArray) {
        for (i in ONE until arrayToSort_.size){
            val numberChecking = arrayToSort_[i]
            var j = i - 1
            while (j >= ZERO && arrayToSort_[j] > numberChecking){
                arrayToSort_[j + ONE] = arrayToSort_[j]
                j -= ONE
            }
            arrayToSort_[j + ONE] = numberChecking
        }
    }
}