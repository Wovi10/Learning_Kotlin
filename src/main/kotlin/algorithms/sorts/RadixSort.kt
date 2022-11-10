package algorithms.sorts

import algorithms.utils.AlgorithmConstants.NUMBER_BASE
import algorithms.utils.AlgorithmConstants.SORT_TEXT
import algorithms.utils.Utils
import utils.Constants.ONE
import utils.Constants.ZERO
import utils.console.AsciiProgressBar.updateProgressBar
import java.time.LocalDateTime

object RadixSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name = "Radix $SORT_TEXT"

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int): String {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultRadixSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
        return getSortInfo(numRun_)
    }

    private fun defaultRadixSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = Utils.createInputArray(arraySize_, lowestValue_, highestValue_)
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
        for (i in (arraySize - ONE) downTo 0) {
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