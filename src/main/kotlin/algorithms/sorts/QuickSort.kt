package algorithms.sorts

import java.time.LocalDateTime

object QuickSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Quick sort"

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        printStartText(numRun, name)
        for (x in 0 until numRun){
            runQuickSort(size, lowerBound, upperBound)
        }
        printSortInfo(numRun, name)
    }

    private fun runQuickSort(size: Int, lowerBound: Int, upperBound: Int) {
        val arrayToSort = createInputArray(size, lowerBound, upperBound)
        
        TODO("Not yet implemented")
    }

    override fun printStartText(numRun: Int, name: String) {
        println("Started $numRun runs of $name")
    }
}