package algorithms.sorts

import java.time.LocalDateTime

object QuickSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Quick sort"

    override fun sort(arraySize: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        printStartText(numRun, name)
        for (x in 0 until numRun){
            runQuickSort(arraySize, lowerBound, upperBound)
        }
        printSortInfo(numRun, name)
    }

    private fun runQuickSort(arraySize_: Int, lowerBound_: Int, upperBound_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowerBound_, upperBound_)
        val arrayLength = arrayToSort.size
        printArray(arrayToSort)
        quickSort(arrayToSort, 0, arrayLength-1)
        printArray(arrayToSort)
    }

    private fun quickSort(arrayToSort_: IntArray, startIndex_: Int, numOfIndexes_: Int) {
        if (startIndex_ < numOfIndexes_) {
            val parIndex = partition(arrayToSort_, startIndex_, numOfIndexes_)
            quickSort(arrayToSort_, startIndex_, parIndex - 1);
            quickSort(arrayToSort_, parIndex + 1, numOfIndexes_);
        }
    }

    private fun partition(arrayToSort: IntArray, firstIndex: Int, lastIndex: Int): Int {
        val pivot = arrayToSort[lastIndex]

        var i = firstIndex - 1
        for (j in firstIndex .. lastIndex){
            if (arrayToSort[j] < pivot){
                i++
                swapIndexes(arrayToSort, i, j)
            }
        }
        swapIndexes(arrayToSort, i+1, lastIndex)
        return i + 1
    }

    override fun printStartText(numRun: Int, name: String) {
        println("Started $numRun runs of $name")
    }
}