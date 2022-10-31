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
        printArray(arrayToSort)
        val arrayLength = arrayToSort.size
        quickSort(arrayToSort, 0, arrayLength-1)
        printArray(arrayToSort)
    }

    private fun quickSort(arrayToSort: IntArray, startIndex_: Int, endIndex_: Int) {
        if (startIndex_ < endIndex_) {
            val parIndex = partition(arrayToSort, startIndex_, endIndex_)
            quickSort(arrayToSort, startIndex_, parIndex - 1);
            quickSort(arrayToSort, parIndex + 1, endIndex_);
        }
    }

    private fun partition(arrayToSort: IntArray, firstIndex: Int, lastIndex: Int): Int {
        val pivot = arrayToSort[lastIndex]

        var smallIndex = firstIndex - 1
        for (i in firstIndex until lastIndex){
            if (arrayToSort[i] < pivot){
                smallIndex++
                swapIndexes(arrayToSort, smallIndex, i)
            }
        }
        swapIndexes(arrayToSort, smallIndex+1, lastIndex)
        return smallIndex + 1
    }

    override fun printStartText(numRun: Int, name: String) {
        println("Started $numRun runs of $name")
    }
}