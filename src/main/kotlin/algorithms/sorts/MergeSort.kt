package algorithms.sorts

import algorithms.sorts.utils.Constants.MERGE_SORT_TEXT
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

object MergeSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = MERGE_SORT_TEXT
    override var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultMergeSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this, arrayToSort_)
        mergeSort(arrayToSort_, ZERO, arrayToSort_.size - ONE)
        return getSortInfo()
    }

    private fun mergeSort(arrayToSort_: IntArray, lowestIndex_: Int, highestIndex: Int) {
        
    }

    private fun defaultMergeSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {

        TODO("Not yet implemented")
    }
}