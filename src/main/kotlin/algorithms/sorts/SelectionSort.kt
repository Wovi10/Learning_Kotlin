package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOLS
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime

object SelectionSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Selection sort"

    override fun sort(arraySize: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        printStartText(numRun, name)
        for (x in ZERO until numRun) {
            runSelectionSort(arraySize, lowerBound, upperBound)
        }
        printSortInfo(numRun, name)
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
        print(LOADING_SYMBOLS)
    }
}