package algorithms.sorts

import algorithms.sorts.utils.Constants.BOGO_SORT_TEXT
import java.time.LocalDateTime

object BogoSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = BOGO_SORT_TEXT

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_){runNum ->
            defaultBogoSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
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