package algorithms.sorts

import java.time.LocalDateTime

object SelectionSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0 .. numRun){
            runSelectionSort(size, lowerBound, upperBound)
        }

        TODO("Not yet implemented")
    }

    private fun runSelectionSort(size: Int, lowerBound: Int, upperBound: Int) {
        val arrayToSort = createInputArray(size, lowerBound, upperBound)
        println(arrayToSort)
        var smallestIndex: Int
        for (i in 0 .. arrayToSort.size) {
            smallestIndex = i
            for (j in i .. arrayToSort.size) {
                if (arrayToSort[j] < smallestIndex){
                    smallestIndex = j
                }
            }
            arrayToSort[i] xor arrayToSort[smallestIndex]
        }
        println(arrayToSort)
        TODO("Not yet implemented")
    }
}