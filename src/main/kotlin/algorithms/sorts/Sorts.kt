package algorithms.sorts

import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.THOUSAND
import algorithms.utils.Utils
import arraySize
import highestVal
import lowestVal
import numRun
import skipSortList
import sortList

object Sorts {
    fun runAllSortsOnce(): String {
        var resultInfo = "Running sorts once: $NEWLINE"
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue
            val arrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
            resultInfo += sortType.sort(arrayToSort)
        }
        return resultInfo
    }

    fun runAllSortsMultipleTimes(): String {
        var resultInfo = "Running sorts multiple times: $NEWLINE"
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue
            resultInfo += sortType.sort(arraySize, lowestVal, highestVal, numRun, THOUSAND)
        }
        return resultInfo
    }

}