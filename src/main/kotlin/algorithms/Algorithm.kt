package algorithms

import algorithms.utils.AlgorithmConstants
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE_MILLION
import algorithms.utils.AlgorithmConstants.SIXTY
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

abstract class Algorithm {
    protected abstract var startTime: LocalDateTime
    private fun getTimeString(_time: Double): String {
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

    protected fun printStartText(numRun: Int, name: String) {
        println("Started $numRun run(s) of $name")
    }

    protected fun printStartText(arrayToPrint: IntArray, name: String) {
        println(name)
    }

    protected fun printArray(arrayToPrint: IntArray) {
        var stringToPrint = ""
        for (i in arrayToPrint.indices) {
            val indexToPrint = arrayToPrint[i]
            if (stringToPrint.isNotEmpty()) {
                stringToPrint += ", $indexToPrint"
            } else {
                stringToPrint = indexToPrint.toString()
            }
        }
        println(stringToPrint)
    }

    protected fun getCommonSection(name: String, numRun: Int): String {
        return "Ran $name $numRun times. $NEWLINE" + getDuration()
    }

    protected fun getDuration(): String {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / AlgorithmConstants.THOUSAND).toDouble()
        return "It took " + getTimeString(time)
    }

    abstract fun resetVariables()
}