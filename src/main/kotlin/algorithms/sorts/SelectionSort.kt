package algorithms.sorts

import java.time.LocalDateTime

object SelectionSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Selection Sort"

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        println("Started $numRun $name")
        for (x in 0 until numRun){
            runSelectionSort(size, lowerBound, upperBound)
        }
        printSortInfo(numRun, SelectionSort)
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

    private fun swapIndexes(arrayToSort: IntArray, i: Int, smallestIndex: Int) {
        arrayToSort[i] = arrayToSort[i] xor arrayToSort[smallestIndex]
        arrayToSort[smallestIndex] = arrayToSort[i] xor arrayToSort[smallestIndex]
        arrayToSort[i] = arrayToSort[i] xor arrayToSort[smallestIndex]
    }

    private fun printArray(arrayToPrint: IntArray) {
        var stringToPrint = ""
        for (i in arrayToPrint.indices) {
            val indexToPrint = arrayToPrint[i]
            if (stringToPrint.isNotEmpty()){
                stringToPrint += ", $indexToPrint"
            }else{
                stringToPrint = indexToPrint.toString()
            }
        }
        print(stringToPrint)
    }
}