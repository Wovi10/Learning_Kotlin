package algorithms.searches

import kotlin.random.Random

abstract class SearchType {
    abstract var highestNumTries: Int
    abstract var numOnHighestTries: Int
    abstract var lowestNumTries: Int
    abstract var numOnLowestTries: Int
    abstract var cumulativeTries: Int
    abstract var numTries: Int

    abstract fun search(lowerBound: Int, upperBound: Int, numRun: Int)

    abstract fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int)

    open fun printSearchInfo(numRun: Int){
        val averageTries = BinarySearch.cumulativeTries / numRun
        println("Ran Binary search $numRun times.")
        println("Highest number of tries is $highestNumTries (Number was $numOnHighestTries).")
        println("Lowest number of tries is $lowestNumTries (Number was $numOnLowestTries).")
        println("Average number of tries is $averageTries.")
    }
    open fun createNumToFind(lowerBound: Int, upperBound: Int): Int {
        return Random.nextInt(lowerBound, upperBound)
    }

}