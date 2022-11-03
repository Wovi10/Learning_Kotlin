package algorithms.searches.utils

import algorithms.utils.AlgorithmConstants.ZERO

abstract class GuessOnTries {
    var onHighest: Int = ZERO
    var onLowest: Int = ZERO

    fun resetVariables() {
        onHighest = ZERO
        onLowest = ZERO
    }
}