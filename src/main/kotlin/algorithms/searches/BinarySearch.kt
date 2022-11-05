package algorithms.searches

import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import algorithms.utils.AlgorithmConstants.SEARCH_TEXT
import algorithms.utils.AlgorithmConstants.TWO
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime

object BinarySearch : SearchType(GuessOnTries(), NumOfTries()) {
    override val name = "Binary $SEARCH_TEXT"
    override var cumulativeTries = ZERO
    override var numTries = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String {
        resetVariables()
        printStartText(numRun_, name)
        for (x in ZERO until numRun_) { // Until because start from ZERO
            runBinarySearch(lowerBound_, upperBound_)
        }
        return getSearchInfo(numRun_, name)
//        return getEndText(numRun_, name)
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = ZERO
        findNumber(lowerBound, upperBound, numToFind)
        updateSearchData(numToFind)
    }

    override fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int) {
        numTries++
        val middleNumber = getMiddleNum(lowerBound_, upperBound_)
        if (numToFind_ < middleNumber) {
            return findNumber(lowerBound_, middleNumber, numToFind_)
        } else if (numToFind_ > middleNumber) {
            return findNumber(middleNumber, upperBound_, numToFind_)
        }
    }

    private fun getMiddleNum(lowerBound: Int, upperBound: Int): Int {
        val difference = upperBound - lowerBound
        val half = difference / TWO
        return lowerBound + half
    }

}