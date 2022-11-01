package algorithms.sorts

import algorithms.Algorithm
import java.time.LocalDateTime
import kotlin.random.Random

abstract class SortType : Algorithm() {
    abstract override var startTime: LocalDateTime
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

    open fun printEndText(numRun: Int, name: String) {
        printCommonSection(name, numRun)
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

    override fun resetVariables() {
        startTime = LocalDateTime.now()
    }
}