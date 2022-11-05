package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import algorithms.utils.Utils
import java.time.LocalDateTime

object BubbleSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = "Bubble $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int): String {
        resetVariables()
        printStartText(numRun_, name)
        repeat(numRun_){
            val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
            bubbleSort(arrayToSort)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        return getEndText(numRun_, name)
    }

    override fun sort(arrayToSort_: IntArray): String {
        resetVariables()
        printStartText(name)
        bubbleSort(arrayToSort_)
        return getEndText(name)
    }

    private fun bubbleSort(arrayToSort_: IntArray) {
        for (counter in arrayToSort_.indices){
            for (i in ZERO until arrayToSort_.size - ONE){
                if (arrayToSort_[i] > arrayToSort_[i + ONE]){
                    swapIndexes(arrayToSort_, i, i + ONE)
                }
            }
        }
    }
}