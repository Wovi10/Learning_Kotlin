package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.Utils
import java.time.LocalDateTime

object BubbleSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = "Bubble $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        resetVariables()
        printStartText(numRun_, name)
        repeat(numRun_){
            val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
            bubbleSort(arrayToSort)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        printEndText(numRun_, name)
    }

    override fun sort(arrayToSort_: IntArray) {
        resetVariables()
        printStartText(arrayToSort_, name)
        bubbleSort(arrayToSort_)
        printEndText()
    }

    private fun bubbleSort(arrayToSort: IntArray) {
        TODO("Not yet implemented")
    }
}