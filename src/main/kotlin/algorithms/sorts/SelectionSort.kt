package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime

object SelectionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Selection $SORT_TEXT"

    override fun sort(arraySize: Int, lowestValue: Int, highestValue: Int, numRun: Int) {
        resetVariables()
        printStartText(numRun, name)
        for (x in ZERO until numRun) {
            runSelectionSort(arraySize, lowestValue, highestValue)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        printEndText(numRun, name)
    }

    private fun runSelectionSort(size: Int, lowerBound: Int, upperBound: Int) {
        val arrayToSort = createInputArray(size, lowerBound, upperBound)
        var smallestIndex: Int
        for (i in ZERO..arrayToSort.size) {
            smallestIndex = i
            for (j in i until arrayToSort.size) {
                if (arrayToSort[j] < arrayToSort[smallestIndex]) {
                    smallestIndex = j
                }
            }
            if (smallestIndex != i) {
                swapIndexes(arrayToSort, i, smallestIndex)
            }
        }
    }
}