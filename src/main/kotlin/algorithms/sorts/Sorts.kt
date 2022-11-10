package algorithms.sorts

import utils.Utils
import arraySize
import highestVal
import lowestVal
import skipSortList
import sortList
import sort_numRun
import utils.Constants.EMPTY_STRING
import utils.Constants.NEWLINE
import utils.Constants.ONE

private const val RUNNING_EACH_SORT = "Running each sort"

object Sorts {
    fun runSorts(): String {
        if (skipSortList.size > sortList.size) return EMPTY_STRING
        val output = if (sort_numRun == ONE) {
            runAllSortsOnce()
        } else {
            runAllSortsMultipleTimes()
        }
        return output
    }

    private fun runAllSortsMultipleTimes(): String {
        println("$RUNNING_EACH_SORT $sort_numRun times.")
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue
            sortType.sort(arraySize, lowestVal, highestVal, sort_numRun)
        }
        return EMPTY_STRING
    }

    private fun runAllSortsOnce(): String {
        println("$RUNNING_EACH_SORT once.")
        var resultInfo = "Ran sorts once: $NEWLINE"
        for (sortType in sortList) {
            if (skipSortList.contains(sortType)) continue
            val arrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
            resultInfo += sortType.sort(arrayToSort)
        }
        return resultInfo
    }
}