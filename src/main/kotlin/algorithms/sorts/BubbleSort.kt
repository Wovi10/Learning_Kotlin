package algorithms.sorts

import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.TEN
import algorithms.utils.Utils
import algorithms.utils.Utils.swapIndexes
import utils.Constants.ONE
import utils.Constants.ZERO
import utils.console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object BubbleSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = "Bubble $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int): String {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultBubbleSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
        return getSortInfo(numRun_)
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