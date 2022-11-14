package algorithms.sorts

import algorithms.sorts.utils.Constants.BUBBLE_SORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import algorithms.sorts.utils.Functions.swapIndexes
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

object BubbleSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = BUBBLE_SORT_TEXT
    override var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        if (lowestValue_ > highestValue_) return
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultBubbleSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this)
        bubbleSort(arrayToSort_)
        return getSortInfo()
    }

    private fun defaultBubbleSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowestValue_, highestValue_)
        bubbleSort(arrayToSort)
    }

    private fun bubbleSort(arrayToSort_: IntArray) {
        for (counter in arrayToSort_.indices) {
            for (i in ZERO until arrayToSort_.size - ONE) {
                val iPlusOne = i + ONE
                if (arrayToSort_[i] > arrayToSort_[iPlusOne]) swapIndexes(arrayToSort_, i, (iPlusOne))
            }
        }
    }
}