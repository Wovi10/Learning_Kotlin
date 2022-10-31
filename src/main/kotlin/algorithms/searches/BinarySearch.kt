package algorithms.searches

import java.time.LocalDateTime

object BinarySearch: SearchType() {
    override val name = "Binary search"
    override var highestNumTries = 0
    override var numOnHighestTries = 0
    override var lowestNumTries = 500
    override var numOnLowestTries = 0
    override var cumulativeTries = 0
    override var numTries = 0
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun search(lowerBound: Int, upperBound: Int, numRun: Int) {
        resetVariables()
        for (x in 0 until numRun) {
            runBinarySearch(lowerBound, upperBound)
        }
        printSearchInfo(numRun, BinarySearch)
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = 0
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
        val half = difference / 2
        return lowerBound + half
    }

}