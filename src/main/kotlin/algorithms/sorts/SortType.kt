package algorithms.sorts

import kotlin.random.Random

abstract class SortType {
    abstract fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int)

    open fun createInputArray(size: Int, lowerBound: Int, upperBound: Int): IntArray{
        val outputArray = IntArray(size)
        for (x in 0 .. size){
            val randomNumber = Random.nextInt(lowerBound, upperBound+1)
            outputArray[x] = randomNumber
        }
        return outputArray
    }
}