package algorithms.searches

import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.SEARCH_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime

object LinearSearch : SearchType() {
    override val name = "Linear $SEARCH_TEXT"
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
            runLinearSearch(lowerBound, upperBound)
        }
        printSearchInfo(numRun, name)
    }

    private fun runLinearSearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = ZERO
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

    private fun getNumToTry(lowerBound: Int): Int {
        return lowerBound + ONE
    }
}