package algorithms.searches

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.THOUSAND
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random

abstract class SearchType : Algorithm() {
    protected abstract val name: String
    protected abstract var highestNumTries: Int
    protected abstract var numOnHighestTries: Int
    protected abstract var lowestNumTries: Int
    protected abstract var numOnLowestTries: Int
    protected abstract var cumulativeTries: Int
    protected abstract var numTries: Int
    protected abstract var startTime: LocalDateTime

    abstract fun search(lowerBound: Int, upperBound: Int, numRun: Int)

    abstract fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int)

    open fun printSearchInfo(numRun: Int, name: String) {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / THOUSAND).toDouble()
        val timeString = "It took " + getTimeString(time)
        val averageTries = cumulativeTries / numRun
        println("Ran $name $numRun times.")
        println("Highest number of tries is $highestNumTries (Number was $numOnHighestTries).")
        println("Lowest number of tries is $lowestNumTries (Number was $numOnLowestTries).")
        println("Average number of tries is $averageTries.")
        println(timeString)
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
        highestNumTries = ZERO
        numOnHighestTries = ZERO
        lowestNumTries = Int.MAX_VALUE
        numOnLowestTries = ZERO
        cumulativeTries = ZERO
        numTries = ZERO
        startTime = LocalDateTime.now()
    }
}