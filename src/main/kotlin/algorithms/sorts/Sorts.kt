package algorithms.sorts

import algorithms.utils.AlgorithmConstants.THOUSAND
import algorithms.utils.Utils
import arraySize
import highestVal
import lowestVal
import sort_numRun
import skipSortList
import sortList
import utils.Constants.NEWLINE

object Sorts {
    fun runAllSortsMultipleTimes(): String {
        println("Running each sort $sort_numRun times.")
        var resultInfo = "Ran sorts multiple times: $NEWLINE"
        for (sortType in sortList) {
//            if (skipSortList.contains(sortType)) continue
            resultInfo += sortType.sort(arraySize, lowestVal, highestVal, sort_numRun, THOUSAND)
        }
        return resultInfo
    }

    fun runAllSortsOnce(): String {
        println("Running each sort once.")
        var resultInfo = "Ran sorts once: $NEWLINE"
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue
            val arrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
            resultInfo += sortType.sort(arrayToSort)
        }
        return resultInfo
    }
}