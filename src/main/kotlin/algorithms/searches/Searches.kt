package algorithms.searches

import highestVal
import lowestVal
import searchList
import search_numRun
import skipSearchList
import utils.Constants.NEWLINE
import utils.Constants.ONE

object Searches {
    fun runSearches(): String {
        var output = if (search_numRun == ONE) {
            println("Running each sort once.")
            "Ran searches once: $NEWLINE"
        } else {
            println("Running each sort $search_numRun times.")
            "Ran searches multiple times: $NEWLINE"
        }
        for (searchType in searchList) {
            if (skipSearchList.contains(searchType)) continue
            output += searchType.search(lowestVal, highestVal, search_numRun)
        }
        return output
    }
}