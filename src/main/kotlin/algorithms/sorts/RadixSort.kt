package algorithms.sorts

import algorithms.utils.AlgorithmConstants.NUMBER_BASE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.ZERO
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
        radixSort(arrayToSort, arraySize_)
        TODO("Not yet implemented")
    }

    private fun radixSort(arrayToSort_: IntArray, arraySize_: Int) {
        val max = getMax(arrayToSort_, arraySize_)
        var numOfDigits = getNumDigits(max)
        var placeValue = 1
        while (numOfDigits-- > 0){
            countSort(arrayToSort_, placeValue)
            placeValue *= NUMBER_BASE
        }
    }

    private fun countSort(arrayToSort_: IntArray, placeValue: Int) {
        

        TODO("Not yet implemented")
    }

    fun getNumDigits(max_: Int): Int {
        var max = max_
        var numOfDigits = ZERO
        while (max > ZERO){
            numOfDigits += ONE
            max /= NUMBER_BASE
        }
        return numOfDigits
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