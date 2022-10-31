package algorithms.sorts

import java.time.LocalDateTime

object SelectionSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Selection sort"

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        println("Started $numRun $name")
        for (x in 0 until numRun){
            runSelectionSort(size, lowerBound, upperBound)
        }
        printSortInfo(numRun, name)
    }

    override fun printStartText(numRun: Int, name: String) {
        println("Started $numRun runs of $name")
    }

    private fun runSelectionSort(size: Int, lowerBound: Int, upperBound: Int) {
        val arrayToSort = createInputArray(size, lowerBound, upperBound)
        var smallestIndex: Int
        for (i in 0 .. arrayToSort.size) {
            smallestIndex = i
            for (j in i until arrayToSort.size) {
                if (arrayToSort[j] < arrayToSort[smallestIndex]){
                    smallestIndex = j
                }
            }
            if (smallestIndex != i){
                swapIndexes(arrayToSort, i, smallestIndex)
            }
        }
        print("| ")
    }
}