package algorithms.searches.utils

import algorithms.utils.AlgorithmConstants.ZERO

abstract class NumOfTries {
    var highest: Int = ZERO
    var lowest: Int = Int.MAX_VALUE

    fun resetVariables() {
        highest = ZERO
        lowest = Int.MAX_VALUE
    }
}