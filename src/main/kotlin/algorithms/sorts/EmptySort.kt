package algorithms.sorts

import algorithms.sorts.utils.Constants.EMPTY_SORT_TEXT
import utils.Constants
import utils.Constants.ZERO
import java.time.LocalDateTime

private const val EMPTYSORT_TEXT = "This is an empty sort"

object EmptySort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = EMPTY_SORT_TEXT
    override var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        System.err.println(EMPTYSORT_TEXT)
    }

    override fun sort(arrayToSort_: IntArray): String {
        System.err.println(EMPTYSORT_TEXT)
        return EMPTYSORT_TEXT
    }
}