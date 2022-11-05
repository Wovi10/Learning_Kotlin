package algorithms.searches.utils

import algorithms.utils.AlgorithmConstants.ZERO

class GuessOnTries {
    var onLowest: Int = ZERO
    var onHighest: Int = ZERO

    fun resetVariables() {
        onHighest = ZERO
        onLowest = ZERO
    }

    fun setBoth(value: Int) {
        onHighest = value
        onLowest = value
    }
}