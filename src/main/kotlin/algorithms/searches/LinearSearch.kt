package algorithms.searches

object LinearSearch: SearchType() {
    override var highestNumTries = 0
    override var numOnHighestTries = 0
    override var lowestNumTries = 500
    override var numOnLowestTries = 0
    override var cumulativeTries = 0
    override var numTries = 0

    override fun search(lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0..numRun) {
            runLinearSearch(lowerBound, upperBound)
        }
        printSearchInfo(numRun)
    }

    private fun runLinearSearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = 0
        findNumber(lowerBound, upperBound, numToFind)
        updateSearchData(numToFind)
    }

    private fun updateSearchData(numToFind: Int) {
        if (numTries > highestNumTries) {
            highestNumTries = numTries
            numOnHighestTries = numToFind
        } else if (numTries < lowestNumTries) {
            lowestNumTries = numTries
            numOnLowestTries = numToFind
        }
        cumulativeTries += numTries
    }

    override fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int) {
        TODO("Not yet implemented")
    }
}