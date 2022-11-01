package algorithms.sorts

import algorithms.utils.AlgorithmConstants.NUMBER_BASE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import java.time.LocalDateTime
import java.util.Collections.copy

object RadixSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Radix $SORT_TEXT"

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
    }

    private fun radixSort(arrayToSort_: IntArray, arraySize_: Int) {
        val max = getMax(arrayToSort_, arraySize_)
        var numOfDigits = getNumDigits(max)
        var placeValue = 1
        printArray(arrayToSort_)
        println("Starting sort")
        while (numOfDigits-- > 0){
            countSort(arrayToSort_, placeValue)
            placeValue *= NUMBER_BASE
            printArray(arrayToSort_)
        }
//        printArray(arrayToSort_)
    }

    private fun countSort(arrayToSort_: IntArray, placeValue: Int){
        val output = IntArray(arrayToSort_.size)
        val frequency = IntArray(NUMBER_BASE)
        frequency.fill(0)

        // Calculate frequency of digits
        for (i in arrayToSort_.indices){
            frequency[(arrayToSort_[i] / placeValue) % NUMBER_BASE]++
        }
        println("Printing frequency")
        printArray(frequency)

        // Put numbers at right index
//        for (i in ONE until NUMBER_BASE){
//            frequency[i] = frequency[i - ONE]
//        }
//        println("Putting numbers at right index")
//        printArray(frequency)

        // Build output array
        for (i in (arrayToSort_.size - ONE) .. 0){
            output[frequency[(arrayToSort_.size/placeValue) % NUMBER_BASE] - ONE] = arrayToSort_[i]
            frequency[(arrayToSort_[i] / placeValue) % NUMBER_BASE]--
        }
        println("Printing output")
        printArray(output)

        // Copy output into arrayToSort
        for (i in arrayToSort_.indices){
            arrayToSort_[i] = output[i]
        }
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
        for (i in ONE until arraySize_) {
            if (arrayToSort_[i] > max){
                max = arrayToSort_[i]
            }
        }
        return max
    }
}