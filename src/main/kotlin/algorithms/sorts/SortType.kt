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
        var time = startTime.until(stopTime, ChronoUnit.NANOS).toDouble()
        val timeString: String
        if (time >= 1000000000) {
            time /= 1000000000
            if (time >= 60){
                time /= 60
                if (time >= 60){
                    time /= 60
                    timeString = "It took $time hours."
                }else{
                    timeString = "It took $time minutes."
                }
            }else{
                timeString = "It took $time seconds."
            }
        } else {
            
            timeString = "It took $time nanos."
        }
        println("Ran ${sortType.name} $numRun times.")
        println(timeString)
        println()
    }
}