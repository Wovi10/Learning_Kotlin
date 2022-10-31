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

    open fun printSortInfo(numRun: Int, sortType: SortType) {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS)/1000000).toDouble()
        val timeString = getTimeString(time)
        println("Ran ${sortType.name} $numRun times.")
        println(timeString)
        println()
    }
}