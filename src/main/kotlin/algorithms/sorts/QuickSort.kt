package algorithms.sorts

import java.time.LocalDateTime

object QuickSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Quick sort"

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        TODO("Not yet implemented")
    }
}