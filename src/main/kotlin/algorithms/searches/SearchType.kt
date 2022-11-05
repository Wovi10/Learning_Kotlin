package algorithms.searches

import algorithms.Algorithm
import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.TAB
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime
import kotlin.random.Random

abstract class SearchType(private var guessOnTries: GuessOnTries, private var numOfTries: NumOfTries) : Algorithm() {
    constructor() : this(
        guessOnTries = GuessOnTries(),
        numOfTries = NumOfTries()
    )

    protected abstract val name: String
    protected abstract var cumulativeTries: Int
    protected abstract var numTries: Int
    abstract override var startTime: LocalDateTime

    abstract fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String

    abstract fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int)

    open fun getSearchInfo(numRun_: Int, name_: String): String {
        var searchInfo: String = getCommonSection(name_, numRun_) + NEWLINE
        if (numRun_ == ONE) {
            return searchInfo
        }
        val averageTries = cumulativeTries / numRun_
        searchInfo += TAB + "Highest number of tries is ${numOfTries.highest} (Number was ${guessOnTries.onHighest}). $NEWLINE"
        searchInfo += TAB + "Lowest number of tries is ${numOfTries.lowest} (Number was ${guessOnTries.onLowest}). $NEWLINE"
        searchInfo += TAB + "Average number of tries is $averageTries. $NEWLINE"

        return searchInfo
    }

    open fun createNumToFind(lowerBound_: Int, upperBound_: Int): Int {
        return Random.nextInt(lowerBound_, upperBound_)
    }

    open fun updateSearchData(numToFind_: Int, numRun_: Int) {
        if (numRun_ == ONE) {
            numOfTries.setBoth(numTries)
            guessOnTries.setBoth(numToFind_)
        } else {
            if (numTries > numOfTries.highest) {
                numOfTries.highest = numTries
                guessOnTries.onHighest = numToFind_
            } else if (numTries < numOfTries.lowest) {
                numOfTries.lowest = numTries
                guessOnTries.onLowest = numToFind_
            }
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