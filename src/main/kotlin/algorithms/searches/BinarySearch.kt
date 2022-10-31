package algorithms.searches

import kotlin.random.Random

object BinarySearch {
    private var highestNumTries = 1
    private var numOnHighestTries = 0
    private var lowestNumTries = 500
    private var numOnLowestTries = 0
    private var cumulativeTries = 0
    private var numTries = 0
    fun binarySearch(lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0..numRun) {
            runBinarySearch(lowerBound, upperBound)
        }
        val averageTries = cumulativeTries / numRun
        println("Ran Binary search $numRun times.")
        println("Highest number of tries is $highestNumTries (Number was $numOnHighestTries).")
        println("Lowest number of tries is $lowestNumTries (Number was $numOnLowestTries).")
        println("Average number of tries is $averageTries.")
    }

    private fun runBinarySearch(lowerBound: Int, upperBound: Int) {
        val numToFind = createNumToFind(lowerBound, upperBound)
        numTries = 0
        findNumber(lowerBound, upperBound, numToFind)
        if (numTries > highestNumTries){
            highestNumTries = numTries
            numOnHighestTries = numToFind
        }else if (numTries < lowestNumTries){
            lowestNumTries = numTries
            numOnLowestTries = numToFind
        }
        cumulativeTries += numTries
    }

    private fun findNumber(lowerBound: Int, upperBound: Int, numToFind: Int) {
        numTries++
        val middleNumber = getMiddleNum(lowerBound, upperBound)
        if (numToFind < middleNumber) {
//            println("$middleNumber is too high!")
            return findNumber(lowerBound, middleNumber, numToFind)
        } else if (numToFind > middleNumber) {
//            println("$middleNumber is too low!")
            return findNumber(middleNumber, upperBound, numToFind)
        }
//        println("Found the number in $numTries times! Number was $numToFind")
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