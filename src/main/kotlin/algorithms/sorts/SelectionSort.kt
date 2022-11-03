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

    override fun sort(arraySize_: Int, lowestValue: Int, highestValue: Int, numRun: Int) {
        resetVariables()
        printStartText(numRun, name)
        for (x in ZERO until numRun) {
            val arrayToSort = Utils.createInputArray(arraySize_, lowestValue, highestValue)
            selectionSort(arrayToSort)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        printEndText(numRun, name)
    }

    override fun sort(arrayToSort_: IntArray) {
        resetVariables()
        printStartText(arrayToSort_, name)
        selectionSort(arrayToSort_)
        printEndText()
    }

    private fun selectionSort(arrayToSort_: IntArray) {
        var smallestIndex: Int
        for (i in ZERO..arrayToSort_.size) {
            smallestIndex = i
            for (j in i until arrayToSort_.size) {
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