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
        val time = (startTime.until(stopTime, ChronoUnit.NANOS)/1000000).toDouble()
        val timeString = reformattedTime(time)
        println("Ran ${sortType.name} $numRun times.")
        println(timeString)
        println()
    }

    private fun reformattedTime(_time: Double): String{
        var time = _time
        if (time < 1000){
            return "It took $time nanos."

        }
        time /= 1000
        if (time < 60){
            return "It took $time seconds."
        }
        time /= 60
        if (time < 60){
            return "It took $time minutes."
        }
        time /= 60
        return "It took $time hours."
    }
}