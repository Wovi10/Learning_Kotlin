package algorithms

import algorithms.utils.AlgorithmConstants
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE_MILLION
import algorithms.utils.AlgorithmConstants.SIXTY
import algorithms.utils.AlgorithmConstants.TAB
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

abstract class Algorithm {
    protected abstract var startTime: LocalDateTime

    abstract fun resetVariables()
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

    protected fun printStartText(numRun_: Int, name_: String) {
        println("Started $numRun_ run(s) of $name_")
    }

    protected fun printStartText(arrayToPrint_: IntArray, name_: String) {
        printArray(arrayToPrint_)
        println(name_)
    }

    protected fun printStartText(name_: String) {
        println(name_)
    }

    private fun printArray(arrayToPrint_: IntArray) {
        var stringToPrint = ""
        for (i in arrayToPrint_.indices) {
            val indexToPrint = arrayToPrint_[i]
            if (stringToPrint.isNotEmpty()) {
                stringToPrint += ", $indexToPrint"
            } else {
                stringToPrint = indexToPrint.toString()
            }
        }
        println(stringToPrint)
    }

    protected fun getEndText(numRun_: Int, name_: String): String {
        return getCommonSection(name_, numRun_) + NEWLINE
    }

    protected fun getEndText(name_: String): String {
        return "$name_: " + getDuration() + NEWLINE
    }

    protected fun getCommonSection(name_: String, numRun_: Int): String {
        var commonSection = "$name_ $NEWLINE"
        commonSection += TAB + "Ran $numRun_ times. $NEWLINE"
        commonSection += TAB + getDuration()
        return commonSection
    }

    protected fun getDuration(): String {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / AlgorithmConstants.THOUSAND).toDouble()
        return "It took " + getTimeString(time)
    }
}