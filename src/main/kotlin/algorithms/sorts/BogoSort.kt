package algorithms.sorts

import algorithms.sorts.utils.Constants.BOGO_SORT_TEXT
import consoleInteraction.AsciiProgressBar
import consoleInteraction.AsciiProgressBar.updateProgressBar
import utils.Constants
import java.time.LocalDateTime

object BogoSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = BOGO_SORT_TEXT

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_){runNum ->
            defaultBogoSort(arraySize_, lowestValue_, highestValue_)
            val durationText: String = if (runNum + Constants.ONE == numRun_) getDuration()
            else Constants.EMPTY_STRING
            updateProgressBar(runNum, numRun_, durationText)
        }
        TODO("Not yet implemented")
    }

    private fun defaultBogoSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        TODO("Not yet implemented")
    }

    override fun sort(arrayToSort_: IntArray): String {
        TODO("Not yet implemented")
    }
}