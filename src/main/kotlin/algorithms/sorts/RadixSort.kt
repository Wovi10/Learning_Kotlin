package algorithms.sorts

import algorithms.sorts.utils.Constants.RADIX_SORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

private const val NUMBER_BASE = 10

object RadixSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = RADIX_SORT_TEXT
    override var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        if (lowestValue_ > highestValue_) return
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultRadixSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
    }

    private fun defaultRadixSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowestValue_, highestValue_)
        radixSort(arrayToSort)
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this)
        radixSort(arrayToSort_)
        return getSortInfo()
    }

    private fun radixSort(arrayToSort_: IntArray) {
        val max = getMax(arrayToSort_)
        var numOfDigits = getNumDigits(max)
        var placeValue = ONE
        while (numOfDigits-- > ZERO) {
            countSort(arrayToSort_, placeValue)
            placeValue *= NUMBER_BASE
        }
    }

    private fun countSort(inputArray_: IntArray, placeValue: Int) {
        val arraySize = inputArray_.size
        val sortedArray = IntArray(arraySize)
        val digitFrequency = IntArray(NUMBER_BASE)
        digitFrequency.fill(ZERO)

        calcFreqOfDigits(inputArray_, digitFrequency, placeValue)
        putNumRightIndex(digitFrequency)
        fillSortedArray(arraySize, inputArray_, sortedArray, digitFrequency, placeValue)
        copyArray(sortedArray, inputArray_)
    }

    private fun copyArray(from: IntArray, to: IntArray) {
        if (from.size == to.size) {
            for (i in from.indices) {
                to[i] = from[i]
            }
        }
    }

    private fun fillSortedArray(
        arraySize: Int,
        inputArray: IntArray,
        sortedArray: IntArray,
        digitFrequency: IntArray,
        placeValue: Int
    ) {
        for (i in (arraySize - ONE) downTo ZERO) {
            val freqNumToWrite = digitFrequency[(inputArray[i] / placeValue) % NUMBER_BASE]
            sortedArray[freqNumToWrite - ONE] = inputArray[i]
            digitFrequency[(inputArray[i] / placeValue) % NUMBER_BASE]--
        }
    }

    private fun putNumRightIndex(digitFrequency: IntArray) {
        for (i in ONE until NUMBER_BASE) {
            digitFrequency[i] += digitFrequency[i - ONE]
        }
    }

    private fun calcFreqOfDigits(inputArray: IntArray, digitFrequency: IntArray, placeValue: Int) {
        for (i in inputArray) {
            digitFrequency[(i / placeValue) % NUMBER_BASE]++
        }
    }

    private fun getNumDigits(max_: Int): Int {
        var max = max_
        var numOfDigits = ZERO
        while (max > ZERO) {
            numOfDigits += ONE
            max /= NUMBER_BASE
        }
        return numOfDigits
    }

    private fun getMax(arrayToSort_: IntArray): Int {
        var max = arrayToSort_[ZERO]
        for (i in arrayToSort_) {
            if (i > max) max = i
        }
        return max
    }
}