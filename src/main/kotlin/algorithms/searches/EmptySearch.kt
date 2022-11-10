package algorithms.searches

import utils.Constants.Algorithm.SearchTypes.EMPTYSEARCH_TEXT
import utils.Constants.ZERO
import java.time.LocalDateTime

private const val EMPTY_SEARCH_TEXT = "This is an empty search"

object EmptySearch: SearchType() {
    override val name: String = EMPTYSEARCH_TEXT
    override var cumulativeTries: Int = ZERO
    override var numTries: Int = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String {
        System.err.println(EMPTY_SEARCH_TEXT)
        return EMPTY_SEARCH_TEXT
    }

    override fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int, numToTry: Int) {
        return
    }
}