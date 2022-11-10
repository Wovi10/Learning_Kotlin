package algorithms.searches.utils

import utils.Constants.ZERO

class NumOfTries {
    var highest: Int = ZERO
    var lowest: Int = Int.MAX_VALUE

    fun resetVariables() {
        highest = ZERO
        lowest = Int.MAX_VALUE
    }

    fun setBoth(value: Int) {
        highest = value
        lowest = value
    }
}