package algorithms.searches

import highestVal
import lowestVal
import searchList
import search_numRun
import skipSearchList
import utils.Constants.EMPTY_STRING
import utils.Constants.NEWLINE
import utils.Constants.ONE

private const val RUNNING_EACH_SEARCH = "Running each search"

object Searches {
    fun runSearches(): String {
        if (skipSearchList.size > searchList.size) return EMPTY_STRING
        var output = "Ran searches"

        output += if (search_numRun == ONE) {
            println("$RUNNING_EACH_SEARCH once.")
            "once"
        } else {
            println("$RUNNING_EACH_SEARCH $search_numRun times.")
            "multiple times"
        }

        output += ": $NEWLINE"

        for (searchType in searchList) {
            if (skipSearchList.contains(searchType)) continue
            output += searchType.search(lowestVal, highestVal, search_numRun)
        }
        return output
    }
}