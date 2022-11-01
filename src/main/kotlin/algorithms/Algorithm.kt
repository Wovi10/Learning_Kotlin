package algorithms

import algorithms.utils.AlgorithmConstants
import algorithms.utils.AlgorithmConstants.ONE_MILLION
import algorithms.utils.AlgorithmConstants.SIXTY
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

abstract class Algorithm {
    protected abstract var startTime: LocalDateTime
    open fun getTimeString(_time: Double): String {
        var time = _time
        if (time < ONE_MILLION) {
            return "$time thousand nanos."
        }
        time /= ONE_MILLION
        if (time < SIXTY) {
            return "$time seconds."
        }
        time /= SIXTY
        if (time < SIXTY) {
            return "$time minutes."
        }
        time /= SIXTY
        return "$time hours."
    }

    open fun printStartText(numRun: Int, name: String) {
        println("Started $numRun run(s) of $name")
    }

    open fun printCommonSection(name: String, numRun: Int) {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / AlgorithmConstants.THOUSAND).toDouble()
        val timeString = "It took " + getTimeString(time)
        println("Ran $name $numRun times.")
        println(timeString)
    }

    abstract fun resetVariables()
}