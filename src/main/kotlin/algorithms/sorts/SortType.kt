package algorithms.sorts

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random

abstract class SortType {
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
        val seconds = startTime.until(stopTime, ChronoUnit.SECONDS).toDouble()
        println("Ran ${sortType.name} $numRun times.")
        println("It took $seconds seconds.")
        println()
    }
}