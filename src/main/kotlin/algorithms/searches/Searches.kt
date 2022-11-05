package algorithms.searches

import highestVal
import lowestVal
import numRun

object Searches {
    private val searchList = listOf(BinarySearch, LinearSearch)
    private val skipSearchList = listOf(BinarySearch, LinearSearch)

    fun runSearchesMultipleTimes(){
        for (searchType in searchList) {
            if (skipSearchList.contains(searchType)) continue
            searchType.search(lowestVal, highestVal, numRun)
        }
    }
}