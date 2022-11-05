package algorithms.sorts

import algorithms.utils.Utils
import arraySize
import highestVal
import lowestVal
import numRun

object Sorts {
    private val sortList = listOf(QuickSort, RadixSort, SelectionSort, InsertionSort, BubbleSort)
    private val skipSortList = listOf(SelectionSort, InsertionSort)

    fun runAllSortsOnce() {
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue

            val arrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
            sortType.sort(arrayToSort)
        }
    }

    fun runAllSortsMultipleTimes() {
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue
            sortType.sort(arraySize, lowestVal, highestVal, numRun)
        }
    }

}