package algorithms.searches

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime
import kotlin.random.Random

abstract class SearchType : Algorithm() {
    protected abstract val name: String
    protected abstract var highestNumTries: Int
    protected abstract var numOnHighestTries: Int
    protected abstract var lowestNumTries: Int
    protected abstract var numOnLowestTries: Int
    protected abstract var cumulativeTries: Int
    protected abstract var numTries: Int
    abstract override var startTime: LocalDateTime

    abstract fun search(lowerBound: Int, upperBound: Int, numRun: Int)

    abstract fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int)

    open fun printSearchInfo(numRun: Int, name: String) {
        println(getCommonSection(name, numRun))
        val averageTries = cumulativeTries / numRun
        println("Highest number of tries is $highestNumTries (Number was $numOnHighestTries).")
        println("Lowest number of tries is $lowestNumTries (Number was $numOnLowestTries).")
        println("Average number of tries is $averageTries.")
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

    override fun resetVariables() {
        highestNumTries = ZERO
        numOnHighestTries = ZERO
        lowestNumTries = Int.MAX_VALUE
        numOnLowestTries = ZERO
        cumulativeTries = ZERO
        numTries = ZERO
        startTime = LocalDateTime.now()
    }
}