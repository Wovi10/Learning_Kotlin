package algorithms.searches

import java.time.LocalDateTime

object LinearSearch : SearchType() {
    override val name = "Linear search"
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
            runLinearSearch(lowerBound, upperBound)
        }
        printSearchInfo(numRun, name)
    }

    private fun runLinearSearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = 0
        findNumber(lowerBound, upperBound, numToFind)
        updateSearchData(numToFind)
    }

    override fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int) {
        numTries++
        val numTried = getNumToTry(lowerBound)
        if (numTried < numToFind) {
            return findNumber(numTried, upperBound, numToFind)
        }
    }

    override fun printStartText(numRun: Int, name: String) {
        println("Started $numRun runs of $name")
    }

    private fun getNumToTry(lowerBound: Int): Int {
        return lowerBound + 1
    }
}