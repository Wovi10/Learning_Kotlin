package algorithms.sorts

import algorithms.utils.AlgorithmConstants.LOADING_SYMBOL
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.NUMBER_BASE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.AlgorithmConstants.ZERO
import algorithms.utils.Utils
import java.time.LocalDateTime

object RadixSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Radix $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue: Int, highestValue: Int, numRun: Int) {
        resetVariables()
        printStartText(numRun, name)
        for (i in ZERO until numRun){
            val arrayToSort = Utils.createInputArray(arraySize_, lowestValue, highestValue)
            radixSort(arrayToSort)
            print(LOADING_SYMBOL)
        }
        print(NEWLINE)
        printEndText(numRun, name)
    }

    override fun sort(arrayToSort_: IntArray) {
        resetVariables()
        printStartText(arrayToSort_, name)
        radixSort(arrayToSort_)
        printEndText(arrayToSort_)
    }

    private fun radixSort(arrayToSort_: IntArray) {
        val max = getMax(arrayToSort_)
        var numOfDigits = getNumDigits(max)
        var placeValue = ONE
        while (numOfDigits-- > ZERO){
            countSort(arrayToSort_, placeValue)
            placeValue *= NUMBER_BASE
        }
    }

    private fun countSort(arrayToSort_: IntArray, placeValue: Int){
        val arraySize = arrayToSort_.size
        val output = IntArray(arraySize)
        val frequency = IntArray(NUMBER_BASE)
        frequency.fill(0)

        // Calculate frequency of digits
        for (i in arrayToSort_.indices){
            frequency[(arrayToSort_[i] / placeValue) % NUMBER_BASE]++
        }
        // Put numbers at right index
        for (i in ONE until NUMBER_BASE){
            frequency[i] += frequency[i - ONE]
        }
        // Build output array
        for (i in (arraySize - ONE) downTo  0){
            val freqNumToWrite = frequency[(arrayToSort_[i] / placeValue) % NUMBER_BASE]
            output[freqNumToWrite - ONE] = arrayToSort_[i]
            frequency[(arrayToSort_[i] / placeValue) % NUMBER_BASE]--
        }

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

    private fun getMax(arrayToSort_: IntArray): Int {
        var max = arrayToSort_[0]
        for (i in ONE until arrayToSort_.size) {
            if (arrayToSort_[i] > max){
                max = arrayToSort_[i]
            }
        }
        return max
    }
}