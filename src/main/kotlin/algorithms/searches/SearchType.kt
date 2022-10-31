package algorithms.searches

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random

abstract class SearchType {
    protected abstract var highestNumTries: Int
    protected abstract var numOnHighestTries: Int
    protected abstract var lowestNumTries: Int
    protected abstract var numOnLowestTries: Int
    protected abstract var cumulativeTries: Int
    protected abstract var numTries: Int
    protected abstract var startTime: LocalDateTime

    abstract fun search(lowerBound: Int, upperBound: Int, numRun: Int)

    abstract fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int)

    open fun printSearchInfo(numRun: Int){
        val stopTime: LocalDateTime = LocalDateTime.now()
        val seconds = startTime.until(stopTime, ChronoUnit.SECONDS).toDouble()
        val averageTries = cumulativeTries / numRun
        println("Ran Binary search $numRun times.")
        println("Highest number of tries is $highestNumTries (Number was $numOnHighestTries).")
        println("Lowest number of tries is $lowestNumTries (Number was $numOnLowestTries).")
        println("Average number of tries is $averageTries.")
        println("It took $seconds seconds")
        println()
    }
    open fun createNumToFind(lowerBound: Int, upperBound: Int): Int {
        return Random.nextInt(lowerBound, upperBound)
    }

    open fun updateSearchData(numToFind: Int) {
        if (numTries > highestNumTries) {
            highestNumTries = numTries
            numOnHighestTries = numToFind
        } else if (numTries < lowestNumTries) {
            lowestNumTries = numTries
            numOnLowestTries = numToFind
        }
        cumulativeTries += numTries
    }

    open fun resetVariables() {
        highestNumTries = 0
        numOnHighestTries = 0
        lowestNumTries = 500
        numOnLowestTries = 0
        cumulativeTries = 0
        numTries = 0
        startTime = LocalDateTime.now()
    }
}