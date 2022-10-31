package algorithms

import algorithms.utils.AlgorithmConstants.ONE_MILLION
import algorithms.utils.AlgorithmConstants.SIXTY

abstract class Algorithm {
    open fun getTimeString(_time: Double): String {
        var time = _time
        if (time < ONE_MILLION) {
            return "It took $time thousand nanos."
        }
        time /= ONE_MILLION
        if (time < SIXTY) {
            return "It took $time seconds."
        }
        time /= SIXTY
        if (time < SIXTY) {
            return "It took $time minutes."
        }
        time /= SIXTY
        return "It took $time hours."
    }

    open fun printStartText(numRun: Int, name: String) {
        println("Started $numRun run(s) of $name")
    }
}