package algorithms.sorts

import java.time.LocalDateTime

object SelectionSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0 until numRun){
            runSelectionSort(size, lowerBound, upperBound)
        }

        TODO("Not yet implemented")
    }

    private fun runSelectionSort(size: Int, lowerBound: Int, upperBound: Int) {
        val arrayToSort = createInputArray(size, lowerBound, upperBound)
        printArray(arrayToSort)
        var smallestIndex: Int
        for (i in arrayToSort.indices) {
            smallestIndex = i
            for (j in i until arrayToSort.size) {
                if (arrayToSort[j] < smallestIndex){
                    smallestIndex = j
                }
            }
            arrayToSort[i] xor arrayToSort[smallestIndex]
        }
        printArray(arrayToSort)
//        TODO("Not yet implemented")
    }

    private fun printArray(arrayToSort: IntArray) {
        for (i in arrayToSort.indices) {
            val indexToPrint = arrayToSort[i]
            print("$indexToPrint, ")
        }
        println()
    }
}