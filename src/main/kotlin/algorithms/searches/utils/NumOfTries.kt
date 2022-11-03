package algorithms.searches.utils

import algorithms.utils.AlgorithmConstants.ZERO

abstract class NumOfTries {
    var highestNumTries: Int = ZERO
    var lowestNumTries: Int = Int.MAX_VALUE

    fun resetVariables() {
        highestNumTries = ZERO
        lowestNumTries = Int.MAX_VALUE
    }
}