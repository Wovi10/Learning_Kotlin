package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import algorithms.utils.Utils
import java.time.LocalDateTime

object SelectionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Selection $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        resetVariables()
        printStartText(numRun_, name)
        repeat(numRun_){
            val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
            selectionSort(arrayToSort)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        printEndText(numRun_, name)
    }

    override fun sort(arrayToSort_: IntArray) {
        resetVariables()
        printStartText(arrayToSort_, name)
        selectionSort(arrayToSort_)
        printEndText()
    }

    private fun selectionSort(arrayToSort_: IntArray) {
        var smallestIndex: Int
        val arraySize = arrayToSort_.size
        for (i in ZERO..arraySize) {
            smallestIndex = i
            for (j in i until arraySize) {
                if (arrayToSort_[j] < arrayToSort_[smallestIndex]) {
                    smallestIndex = j
                }
            }
            if (smallestIndex != i) {
                swapIndexes(arrayToSort_, i, smallestIndex)
            }
        }
    }
}