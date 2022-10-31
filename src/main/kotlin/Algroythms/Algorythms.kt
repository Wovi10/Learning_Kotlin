package Algroythms

import kotlin.random.Random

object Algorythms {
    private var numTries = 1
    fun binarySearch(lowerBound: Int, upperBound: Int) {
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