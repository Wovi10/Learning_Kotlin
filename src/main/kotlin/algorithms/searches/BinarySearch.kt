package algorithms.searches

import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import algorithms.utils.AlgorithmConstants.SEARCH_TEXT
import algorithms.utils.AlgorithmConstants.TWO
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime

object BinarySearch : SearchType() {
    override val name = "Binary $SEARCH_TEXT"
    override var guessOnTries: GuessOnTries
    override var numOfTries: NumOfTries
    override var cumulativeTries = ZERO
    override var numTries = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound: Int, upperBound: Int, numRun: Int) {
        resetVariables()
        for (x in ZERO until numRun) { // Until because start from ZERO
            runBinarySearch(lowerBound, upperBound)
        }
        printSearchInfo(numRun, name)
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = ZERO
        findNumber(lowerBound, upperBound, numToFind)
        updateSearchData(numToFind)
    }

    override fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int) {
        numTries++
        val middleNumber = getMiddleNum(lowerBound, upperBound)
        if (numToFind < middleNumber) {
            return findNumber(lowerBound, middleNumber, numToFind)
        } else if (numToFind > middleNumber) {
            return findNumber(middleNumber, upperBound, numToFind)
        }
    }

    private fun getMiddleNum(lowerBound: Int, upperBound: Int): Int {
        val difference = upperBound - lowerBound
        val half = difference / TWO
        return lowerBound + half
    }

}