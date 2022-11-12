package algorithms.searches

import algorithms.searches.utils.Constants.LINEAR_SEARCH_TEXT
import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

object LinearSearch : SearchType(GuessOnTries(), NumOfTries()) {
    override val name = LINEAR_SEARCH_TEXT
    override var cumulativeTries = ZERO
    override var numTries = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String {
        startup(name, this)
        repeat(numRun_) { runNum ->
            runLinearSearch(lowerBound_, upperBound_, numRun_)
            updateProgressBar(runNum, numRun_)
        }
        return getSearchInfo(numRun_, name)
    }

    private fun runLinearSearch(lowerBound: Int, upperBound: Int, numRun_: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        findNumber(lowerBound, upperBound, numToFind, ZERO)
        updateSearchData(numToFind, numRun_)
    }

    override fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int, numToTry: Int) {
        if (numToTry != numToFind_) {
            val numTried = getNumToTry(lowerBound_)
            findNumber(numToTry, upperBound_, numToFind_, numTried)
        }
        numTries += ONE
    }

    private fun getNumToTry(lowerBound: Int): Int {
        return lowerBound + ONE
    }
}