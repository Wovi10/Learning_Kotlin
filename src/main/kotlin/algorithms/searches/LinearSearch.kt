package algorithms.searches

import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import algorithms.utils.AlgorithmConstants.SEARCH_TEXT
import utils.Constants.ONE
import utils.Constants.ZERO
import utils.console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object LinearSearch : SearchType(GuessOnTries(), NumOfTries()) {
    override val name = "Linear $SEARCH_TEXT"
    override var cumulativeTries = ZERO
    override var numTries = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String {
        startup(numRun_, name, this)
        repeat(numRun_) {runNum ->
            runLinearSearch(lowerBound_, upperBound_, numRun_)
            updateProgressBar(runNum, numRun_)
        }
        return getSearchInfo(numRun_, name)
    }

    private fun runLinearSearch(lowerBound: Int, upperBound: Int, numRun_: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = ZERO
        findNumber(lowerBound, upperBound, numToFind)
        updateSearchData(numToFind, numRun_)
    }

    override fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int) {
        numTries++
        val numTried = getNumToTry(lowerBound_)
        if (numTried < numToFind_) {
            return findNumber(numTried, upperBound_, numToFind_)
        }
    }

    private fun getNumToTry(lowerBound: Int): Int {
        return lowerBound + ONE
    }
}