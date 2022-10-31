package algorithms.searches

import kotlin.random.Random

object BinarySearch: SearchType() {
    override var highestNumTries = 0
    override var numOnHighestTries = 0
    override var lowestNumTries = 500
    override var numOnLowestTries = 0
    override var cumulativeTries = 0
    override var numTries = 0

    override fun search(lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0..numRun) {
            runBinarySearch(lowerBound, upperBound)
        }
        printSearchInfo(numRun)
    }

    override fun printSearchInfo(numRun: Int) {
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
            return findNumber(lowerBound, middleNumber, numToFind)
        } else if (numToFind > middleNumber) {
            return findNumber(middleNumber, upperBound, numToFind)
        }
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