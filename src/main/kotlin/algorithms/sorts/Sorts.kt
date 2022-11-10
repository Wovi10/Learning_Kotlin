package algorithms.sorts

import algorithms.utils.Utils
import arraySize
import highestVal
import lowestVal
import skipSortList
import sortList
import sort_numRun
import utils.Constants.NEWLINE
import utils.Constants.ONE

object Sorts {
    fun runSorts(): String {
        val output = if (sort_numRun == ONE) {
            runAllSortsOnce()
        } else {
            runAllSortsMultipleTimes()
        }
        return output
    }

    private fun runAllSortsMultipleTimes(): String {
        println("Running each sort $sort_numRun times.")
        var resultInfo = "Ran sorts multiple times: $NEWLINE"
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue
            resultInfo += sortType.sort(arraySize, lowestVal, highestVal, sort_numRun)
        }
        return resultInfo
    }

    private fun runAllSortsOnce(): String {
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