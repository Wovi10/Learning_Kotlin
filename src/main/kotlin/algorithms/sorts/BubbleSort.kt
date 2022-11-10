package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.TEN
import algorithms.utils.Utils
import algorithms.utils.Utils.swapIndexes
import utils.Constants.NEWLINE
import utils.Constants.ONE
import utils.Constants.ZERO
import utils.console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object BubbleSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = "Bubble $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int, printFreq_: Int): String {
        var printFreq = printFreq_
        if (printFreq_ > numRun_) printFreq = TEN
        startup(numRun_, name, this)
        repeat(numRun_) { runNum ->
            defaultBubbleSort(arraySize_, lowestValue_, highestValue_)
            if (runNum % printFreq == ZERO) updateProgressBar(runNum / printFreq)
        }
        print(NEWLINE)
        return getSortInfo(numRun_)
    }

    private fun defaultBubbleSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
        bubbleSort(arrayToSort)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(ONE, name, this)
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