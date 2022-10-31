package algorithms.searches

abstract class SearchType {
    abstract var highestNumTries: Int
    abstract var numOnHighestTries: Int
    abstract var lowestNumTries: Int
    abstract var numOnLowestTries: Int
    abstract var cumulativeTries: Int
    abstract var numTries: Int

    abstract fun search(lowerBound: Int, upperBound: Int, numRun: Int)

    abstract fun printSearchInfo(numRun: Int)

}