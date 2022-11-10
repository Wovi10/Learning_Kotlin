package algorithms.sorts

import utils.Utils
import utils.Utils.swapIndexes
import utils.Constants.Algorithm.SortTypes.BUBBLESORT_TEXT
import utils.Constants.EMPTY_STRING
import utils.Constants.ONE
import utils.Constants.ZERO
import console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object BubbleSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = BUBBLESORT_TEXT

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultBubbleSort(arraySize_, lowestValue_, highestValue_)
            val durationText: String = if (runNum + ONE == numRun_) getDuration()
            else EMPTY_STRING
            updateProgressBar(runNum, numRun_, durationText)
        }
    }

    private fun defaultBubbleSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
        bubbleSort(arrayToSort)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this)
        bubbleSort(arrayToSort_)
        return getSortInfo()
    }

    private fun bubbleSort(arrayToSort_: IntArray) {
        for (counter in arrayToSort_.indices) {
            for (i in ZERO until arrayToSort_.size - ONE) {
                val iPlusOne = i + ONE
                if (arrayToSort_[i] > arrayToSort_[iPlusOne]) {
                    swapIndexes(arrayToSort_, i, (iPlusOne))
                }
            }
        }
    }
}