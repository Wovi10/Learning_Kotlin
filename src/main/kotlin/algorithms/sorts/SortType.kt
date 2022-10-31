package algorithms.sorts

import algorithms.Algorithm
import algorithms.utils.AlgorithmConstants.THOUSAND
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random

abstract class SortType : Algorithm() {
    protected abstract var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(arraySize: Int, lowerBound: Int, upperBound: Int, numRun: Int)

    open fun createInputArray(size: Int, lowerBound: Int, upperBound: Int): IntArray {
        val outputArray = IntArray(size)
        for (x in 0 until size) {
            val randomNumber = Random.nextInt(lowerBound, upperBound + 1)
            outputArray[x] = randomNumber
        }
        return outputArray
    }

    open fun printSortInfo(numRun: Int, name: String) {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / THOUSAND).toDouble()
        val timeString = getTimeString(time)
        println("Ran $name $numRun times.")
        println(timeString)
        println()
    }

    open fun printArray(arrayToPrint: IntArray) {
//        var stringToPrint = ""
//        for (i in arrayToPrint.indices) {
//            val indexToPrint = arrayToPrint[i]
//            if (stringToPrint.isNotEmpty()){
//                stringToPrint += ", $indexToPrint"
//            }else{
//                stringToPrint = indexToPrint.toString()
//            }
//        }
//        println(stringToPrint)
    }

    open fun swapIndexes(arrayToSort: IntArray, i: Int, smallestIndex: Int) {
        val temp = arrayToSort[i]
        arrayToSort[i] = arrayToSort[smallestIndex]
        arrayToSort[smallestIndex] = temp
    }
}