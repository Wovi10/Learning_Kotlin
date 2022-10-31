package algorithms.searches

import algorithms.utils.AlgorithmConstants.TWO
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime

object BinarySearch : SearchType() {
    override val name = "Binary search"
    override var highestNumTries = ZERO
    override var numOnHighestTries = ZERO
    override var lowestNumTries = Int.MAX_VALUE
    override var numOnLowestTries = ZERO
    override var cumulativeTries = ZERO
    override var numTries = ZERO
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound: Int, upperBound: Int, numRun: Int) {
        resetVariables()
        for (x in ZERO until numRun) {
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