package algorithms.searches

import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import algorithms.utils.AlgorithmConstants.SEARCH_TEXT
import algorithms.utils.AlgorithmConstants.TWO
import utils.Constants.ONE
import utils.Constants.ZERO
import utils.console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object BinarySearch : SearchType(GuessOnTries(), NumOfTries()) {
    override val name = "Binary $SEARCH_TEXT"
    override var cumulativeTries = ZERO
    override var numTries = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String {
        startup(numRun_, name, this)
        repeat(numRun_) {runNum ->
            runBinarySearch(lowerBound_, upperBound_, numRun_)
            updateProgressBar(runNum, numRun_)
        }
        return getSearchInfo(numRun_, name)
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int, numRun_: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = ZERO
        findNumber(lowerBound, upperBound, numToFind)
        updateSearchData(numToFind, numRun_)
    }

    override fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int) {
        numTries += ONE
        val middleNumber = getMiddleNum(lowerBound_, upperBound_)
        if (numToFind_ < middleNumber) {
            return findNumber(lowerBound_, middleNumber, numToFind_)
        }
        if (numToFind_ > middleNumber) {
            return findNumber(middleNumber, upperBound_, numToFind_)
        }
    }

    private fun getMiddleNum(lowerBound: Int, upperBound: Int): Int {
        val difference = upperBound - lowerBound
        val half = difference / TWO
        return lowerBound + half
    }

}