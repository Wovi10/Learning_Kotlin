package Algroythms

import kotlin.random.Random

object Algorythms {
    private var highestNumTries = 1
    private var lowestNumTries = 1
    private var cummulativeTries = 0
    fun binarySearch(lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0 .. numRun){
            cummulativeTries += runBinarySearch(lowerBound, upperBound)
        }
        val averageTries = cummulativeTries/numRun
        println("Highest number of tries is $highestNumTries")
        println("Lowest number of tries is $lowestNumTries")
        println("Average number of tries is $averageTries")
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int): Int {
        val numToFind = createNumToFind(lowerBound, upperBound)
        findNumber(lowerBound, upperBound, numToFind)
    }

    private fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int): Int {
        val middleNumber = getMiddleNum(lowerBound, upperBound)
        if (numToFind < middleNumber) {
            numTries++
            println("$middleNumber is too high!")
            return findNumber(lowerBound, middleNumber, numToFind)
        } else if (numToFind > middleNumber) {
            numTries++
            println("$middleNumber is too low!")
            return findNumber(middleNumber, upperBound, numToFind)
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