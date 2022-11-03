package algorithms.searches.utils

import algorithms.utils.AlgorithmConstants.ZERO

abstract class GuessOnTries(onHighest: Int = ZERO, onLowest: Int) {
    onHighest = ZERO
    var onLowest: Int = ZERO

    fun resetVariables() {
        onHighest = ZERO
        onLowest = ZERO
    }
}