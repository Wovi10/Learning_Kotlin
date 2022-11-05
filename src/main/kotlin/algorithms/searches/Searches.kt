package algorithms.searches

import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import highestVal
import lowestVal
import numRun

object Searches {
    private val searchList = listOf(BinarySearch, LinearSearch)
    private val skipSearchList = listOf(BinarySearch, LinearSearch)

    fun runSearchesMultipleTimes(): String{
        var resultInfo = "Searches multiple times: $NEWLINE"
        for (searchType in searchList) {
//            if (skipSearchList.contains(searchType)) continue
            resultInfo += searchType.search(lowestVal, highestVal, numRun)
        }
        return resultInfo
    }

    fun runSearchesOnce(): String {
        var resultInfo = "Searches once: $NEWLINE"
        for (searchType in searchList) {
//            if (skipSearchList.contains(searchType)) continue
            resultInfo += searchType.search(lowestVal, highestVal, ONE)
        }
        return resultInfo
    }
}