package algorithms.sorts

import java.time.LocalDateTime

object RadixSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String
        get() = TODO("Not yet implemented")

    override fun sort(arraySize: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        resetVariables()
        for (i in 0 until numRun){
            runRadixSort(arraySize, lowerBound, upperBound)
        }
        printEndText(numRun, name)
    }

    private fun runRadixSort(arraySize_: Int, lowerBound_: Int, upperBound_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowerBound_, upperBound_)
        radixSort()
        TODO("Not yet implemented")
    }

    private fun radixSort(arrayToSort_: IntArray, arraySize_: Int) {
        var max = getMax(arrayToSort_, arraySize_)

//        for (exp = 1; max/exp > 0; exp *= 10){
//
//        }
        TODO("Not yet implemented")
    }

    private fun getMax(arrayToSort_: IntArray, arraySize_: Int): Int {
        var max = arrayToSort_[0]
        for (i in 1.. arraySize_) {
            if (arrayToSort_[i] > max){
                max = arrayToSort_[i]
            }
        }
        return max
    }
}