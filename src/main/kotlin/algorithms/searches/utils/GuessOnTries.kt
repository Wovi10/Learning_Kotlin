package algorithms.searches.utils

import algorithms.utils.AlgorithmConstants.ZERO

abstract class GuessOnTries constructor(onHighest_: Int = ZERO) {
    open var onHighest = ZERO
    open var onLowest: Int = ZERO

    fun resetVariables() {
        onHighest = ZERO
        onLowest = ZERO
    }
}