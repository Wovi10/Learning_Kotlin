package algorithms.sorts

import algorithms.utils.AlgorithmConstants.SORT_TEXT
import java.time.LocalDateTime

private const val EMPTY_SORT_TEXT = "This is an empty sort"

object EmptySort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = "EMPTY $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int, printFreq_: Int): String {
        System.err.println(EMPTY_SORT_TEXT)
        return EMPTY_SORT_TEXT
    }

    override fun sort(arrayToSort_: IntArray): String {
        System.err.println(EMPTY_SORT_TEXT)
        return EMPTY_SORT_TEXT
    }
}