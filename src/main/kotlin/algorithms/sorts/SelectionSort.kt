package algorithms.sorts

import java.time.LocalDateTime

object SelectionSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0 until numRun){
            runSelectionSort(size, lowerBound, upperBound)
        }
    }

    private fun runSelectionSort(size: Int, lowerBound: Int, upperBound: Int) {
        val arrayToSort = createInputArray(size, lowerBound, upperBound)
//        printArray(arrayToSort)
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
//        printArray(arrayToSort)

    }

    private fun swapIndexes(arrayToSort: IntArray, i: Int, smallestIndex: Int) {
        arrayToSort[i] = arrayToSort[i] xor arrayToSort[smallestIndex]
        arrayToSort[smallestIndex] = arrayToSort[i] xor arrayToSort[smallestIndex]
        arrayToSort[i] = arrayToSort[i] xor arrayToSort[smallestIndex]
    }

    private fun printArray(arrayToSort: IntArray) {
        for (i in arrayToSort.indices) {
            val indexToPrint = arrayToSort[i]
            print("$indexToPrint, ")
        }
        println()
    }
}