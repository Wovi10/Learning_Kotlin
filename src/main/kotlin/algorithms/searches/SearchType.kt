package algorithms.searches

import algorithms.Algorithm
import algorithms.searches.utils.GuessOnTries
import algorithms.searches.utils.NumOfTries
import utils.Constants.NEWLINE
import utils.Constants.ONE
import utils.Constants.TAB
import utils.Constants.ZERO
import java.time.LocalDateTime
import kotlin.random.Random

private const val DOUBLE_TAB = TAB + TAB
private const val NEWLINE_DOUBLE_TAB = NEWLINE + DOUBLE_TAB

abstract class SearchType(private var guessOnTries: GuessOnTries, private var numOfTries: NumOfTries) : Algorithm() {
    constructor() : this(
        guessOnTries = GuessOnTries(),
        numOfTries = NumOfTries()
    )

    protected abstract val name: String
    protected abstract var cumulativeTries: Int
    abstract override var startTime: LocalDateTime

    abstract fun search(lowerBound_: Int, upperBound_: Int, numRun_: Int): String

    abstract fun findNumber(lowerBound_: Int, upperBound_: Int, numToFind_: Int, numToTry: Int)

    open fun getSearchInfo(numRun_: Int, name_: String): String {
        var searchInfo = "$TAB$name_$NEWLINE_DOUBLE_TAB"
        if (numRun_ == ONE) return searchInfo
        val averageTries = cumulativeTries / numRun_
        searchInfo += "Highest number of tries is ${numOfTries.highest} (Number was ${guessOnTries.onHighest})."
        searchInfo += NEWLINE_DOUBLE_TAB
        searchInfo += "Lowest number of tries is ${numOfTries.lowest} (Number was ${guessOnTries.onLowest})."
        searchInfo += NEWLINE_DOUBLE_TAB
        searchInfo += "Average number of tries is $averageTries. $NEWLINE"

        return searchInfo
    }

    open fun createNumToFind(lowerBound_: Int, upperBound_: Int): Int {
        return Random.nextInt(lowerBound_, upperBound_)
    }

    open fun updateSearchData(numToFind_: Int, numRun_: Int) {
        cumulativeTries += numTries
        if (numRun_ == ONE) {
            numOfTries.setBoth(numTries)
            guessOnTries.setBoth(numToFind_)
            return
        }
        if (numTries > numOfTries.highest) {
            numOfTries.highest = numTries
            guessOnTries.onHighest = numToFind_
            return
        }
        if (numTries < numOfTries.lowest) {
            numOfTries.lowest = numTries
            guessOnTries.onLowest = numToFind_
            return
        }
    }

    override fun resetVariables() {
        guessOnTries.resetVariables()
        numOfTries.resetVariables()
        cumulativeTries = ZERO
        numTries = ZERO
        startTime = LocalDateTime.now()
    }
}