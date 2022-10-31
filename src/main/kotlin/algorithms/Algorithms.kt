package algorithms

import kotlin.random.Random

object Algorithms {
    private var highestNumTries = 1
    private var lowestNumTries = 500
    private var cumulativeTries = 0
    fun binarySearch(lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0..numRun) {
            runBinarySearch(lowerBound, upperBound)
        }
        val averageTries = cumulativeTries / numRun
//        println("Highest number of tries is $highestNumTries")
//        println("Lowest number of tries is $lowestNumTries")
//        println("Average number of tries is $averageTries")
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        var numTries = 0
        numTries = findNumber(lowerBound, upperBound, numToFind, numTries)
        if (numTries > highestNumTries){
            highestNumTries = numTries
        }else if (numTries < lowestNumTries){
            lowestNumTries = numTries
        }
        println(numTries)
        cumulativeTries += numTries
    }

    private fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int, _numTries: Int): Int {
        val numTries = _numTries + 1
        val middleNumber = getMiddleNum(lowerBound, upperBound)
        if (numToFind < middleNumber) {
            println("$middleNumber is too high!")
            return findNumber(lowerBound, middleNumber, numToFind, numTries)
        } else if (numToFind > middleNumber) {
            println("$middleNumber is too low!")
            return findNumber(middleNumber, upperBound, numToFind, numTries)
        }
        println("Found the number in $numTries times! Number was $numToFind")
        return middleNumber
    }

    private fun getMiddleNum(lowerBound: Int, upperBound: Int): Int {
        val difference = upperBound - lowerBound
        val half = difference / 2
        return lowerBound + half
    }

    private fun createNumToFind(lowerBound: Int, upperBound: Int): Int {
        return Random.nextInt(lowerBound, upperBound)
    }

}