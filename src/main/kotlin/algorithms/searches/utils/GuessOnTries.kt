package algorithms.searches.utils

import utils.Constants.ZERO

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