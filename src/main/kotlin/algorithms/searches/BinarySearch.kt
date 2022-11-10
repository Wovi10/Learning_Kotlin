package algorithms.searches

import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import utils.Constants.Algorithm.SearchTypes.BINARYSEARCH_TEXT
import utils.Constants.Algorithm.TWO
import utils.Constants.EMPTY_STRING
import utils.Constants.ONE
import utils.Constants.ZERO
import console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object BinarySearch : SearchType(GuessOnTries(), NumOfTries()) {
    override val name = BINARYSEARCH_TEXT
    override var cumulativeTries = ZERO
    override var numTries = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String {
        startup(name, this)
        repeat(numRun_) { runNum ->
            runBinarySearch(lowerBound_, upperBound_, numRun_)
            val durationText: String = if (runNum + ONE == numRun_) getDuration()
            else EMPTY_STRING
            updateProgressBar(runNum, numRun_, durationText)
        }
        return getSearchInfo(numRun_, name)
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int, numRun_: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = ZERO
        val middleNumber = getMiddleNum(lowerBound, upperBound)
        findNumber(lowerBound, upperBound, numToFind, middleNumber)
        updateSearchData(numToFind, numRun_)
    }

    override fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int, numToTry: Int) {
        numTries += ONE
        val middleNumber = getMiddleNum(lowerBound_, upperBound_)
        if (numToTry > numToFind_) return findNumber(lowerBound_, numToTry, numToFind_, middleNumber)

        if (numToTry < numToFind_) return findNumber(numToTry, upperBound_, numToFind_, middleNumber)
    }

    private fun getMiddleNum(lowerBound: Int, upperBound: Int): Int {
        val difference = upperBound - lowerBound
        val half = difference / TWO
        return lowerBound + half
    }

}