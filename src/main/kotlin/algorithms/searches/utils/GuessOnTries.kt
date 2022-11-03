package algorithms.searches.utils

import algorithms.utils.AlgorithmConstants.ZERO

abstract class GuessOnTries() {
    open var onHighest = ZERO
    open var onLowest: Int = ZERO

    fun resetVariables() {
        onHighest = ZERO
        onLowest = ZERO
    }
}