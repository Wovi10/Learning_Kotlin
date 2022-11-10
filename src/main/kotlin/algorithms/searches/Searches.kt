package algorithms.searches

import highestVal
import lowestVal
import searchList
import search_numRun
import skipSearchList
import utils.Constants.EMPTY_STRING
import utils.Constants.NEWLINE
import utils.Constants.ONE

object Searches {
    fun runSearches(): String {
        if (skipSearchList.size > searchList.size) return EMPTY_STRING
        var output = if (search_numRun == ONE) {
            println("Running each search once.")
            "Ran searches once: $NEWLINE"
        } else {
            println("Running each search $search_numRun times.")
            "Ran searches multiple times: $NEWLINE"
        }
        for (searchType in searchList) {
            if (skipSearchList.contains(searchType)) continue
            output += searchType.search(lowestVal, highestVal, search_numRun)
        }
        return output
    }
}