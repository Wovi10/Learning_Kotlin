package algorithms

import kotlin.random.Random

object Algorithms {
    private var highestNumTries = 1
    private var lowestNumTries = 500
    private var cumulativeTries = 0
    private var numTries = 0
    fun binarySearch(lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0..numRun) {
            runBinarySearch(lowerBound, upperBound)
        }
        val averageTries = cumulativeTries / numRun
        println("Highest number of tries is $highestNumTries")
        println("Lowest number of tries is $lowestNumTries")
        println("Average number of tries is $averageTries")
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = 0
        findNumber(lowerBound, upperBound, numToFind)
        if (numTries > highestNumTries){
            highestNumTries = numTries
            println("New highest number $highestNumTries")
        }else if (numTries < lowestNumTries){
            lowestNumTries = numTries
        }
        cumulativeTries += numTries
    }

    private fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int) {
        numTries++
        val middleNumber = getMiddleNum(lowerBound, upperBound)
        if (numToFind < middleNumber) {
            println("$middleNumber is too high!")
            return findNumber(lowerBound, middleNumber, numToFind)
        } else if (numToFind > middleNumber) {
            println("$middleNumber is too low!")
            return findNumber(middleNumber, upperBound, numToFind)
        }
        println("Found the number in $numTries times! Number was $numToFind")
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