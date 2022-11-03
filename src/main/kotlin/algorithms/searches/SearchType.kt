package algorithms.searches

import algorithms.Algorithm
import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime
import kotlin.random.Random

abstract class SearchType : Algorithm() {
    protected abstract val name: String
    protected abstract var guessOnTries: GuessOnTries
    protected abstract var numOfTries: NumOfTries
    protected abstract var cumulativeTries: Int
    protected abstract var numTries: Int
    abstract override var startTime: LocalDateTime

    abstract fun search(lowerBound: Int, upperBound: Int, numRun: Int)

    abstract fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int)

    open fun printSearchInfo(numRun: Int, name: String) {
        println(getCommonSection(name, numRun))
        val averageTries = cumulativeTries / numRun
        println("Highest number of tries is ${numOfTries.highest} (Number was ${guessOnTries.onHighest}).")
        println("Lowest number of tries is ${numOfTries.lowest} (Number was ${guessOnTries.onLowest}).")
        println("Average number of tries is $averageTries.")
        println()
    }

    open fun createNumToFind(lowerBound: Int, upperBound: Int): Int {
        return Random.nextInt(lowerBound, upperBound)
    }

    open fun updateSearchData(numToFind: Int) {
        if (numTries > numOfTries.highest) {
            numOfTries.highest = numTries
            guessOnTries.onHighest = numTries
        } else if (numTries < numOfTries.lowest) {
            numOfTries.lowest = numTries
            guessOnTries.onLowest = numToFind
        }
        cumulativeTries += numTries
    }

    override fun resetVariables() {
        guessOnTries.resetVariables()
        numOfTries.resetVariables()
        cumulativeTries = ZERO
        numTries = ZERO
        startTime = LocalDateTime.now()
    }
}