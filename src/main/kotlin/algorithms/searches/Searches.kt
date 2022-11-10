package algorithms.searches

import highestVal
import lowestVal
import numRun
import searchList
import skipSearchList
import utils.Constants.NEWLINE
import utils.Constants.ONE

object Searches {
    fun runSearchesMultipleTimes(): String {
        var resultInfo = "Searches multiple times: $NEWLINE"
        for (searchType in searchList) {
            if (skipSearchList.contains(searchType)) continue
            resultInfo += searchType.search(lowestVal, highestVal, numRun)
        }
        return resultInfo
    }

    fun runSearchesOnce(): String {
        var resultInfo = "Searches once: $NEWLINE"
        for (searchType in searchList) {
            if (skipSearchList.contains(searchType)) continue
            resultInfo += searchType.search(lowestVal, highestVal, ONE)
        }
        return resultInfo
    }
}