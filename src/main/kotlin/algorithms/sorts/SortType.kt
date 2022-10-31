package algorithms.sorts

import algorithms.Algorithm
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random

abstract class SortType: Algorithm() {
    protected abstract var startTime: LocalDateTime
    protected abstract val name: String
    abstract fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int)

    open fun createInputArray(size: Int, lowerBound: Int, upperBound: Int): IntArray{
        val outputArray = IntArray(size)
        for (x in 0 until size){
            val randomNumber = Random.nextInt(lowerBound, upperBound+1)
            outputArray[x] = randomNumber
        }
        return outputArray
    }

    open fun printSortInfo(numRun: Int, name: String) {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS)/1000000).toDouble()
        val timeString = getTimeString(time)
        println("Ran $name $numRun times.")
        println(timeString)
        println()
    }

    open fun printArray(arrayToPrint: IntArray) {
        var stringToPrint = ""
        for (i in arrayToPrint.indices) {
            val indexToPrint = arrayToPrint[i]
            if (stringToPrint.isNotEmpty()){
                stringToPrint += ", $indexToPrint"
            }else{
                stringToPrint = indexToPrint.toString()
            }
        }
        println(stringToPrint)
    }

    open fun swapIndexes(arrayToSort: IntArray, i: Int, smallestIndex: Int) {
        arrayToSort[i] = arrayToSort[i] xor arrayToSort[smallestIndex]
        arrayToSort[smallestIndex] = arrayToSort[i] xor arrayToSort[smallestIndex]
        arrayToSort[i] = arrayToSort[i] xor arrayToSort[smallestIndex]
    }
}