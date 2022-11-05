package algorithms

import algorithms.utils.AlgorithmConstants
import algorithms.utils.AlgorithmConstants.NEWLINE
import algorithms.utils.AlgorithmConstants.ONE
import algorithms.utils.AlgorithmConstants.ONE_MILLION
import algorithms.utils.AlgorithmConstants.SIXTY
import algorithms.utils.AlgorithmConstants.TAB
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

abstract class Algorithm {
    protected abstract var startTime: LocalDateTime

    abstract fun resetVariables()

    private fun printStartText(name_: String, numRun_: Int = 1, arrayToPrint_: IntArray? = null) {
        var startText = ""
        if (numRun_ != ONE){
            startText = "Started $numRun_ runs of "
        }
        println(startText + name_)
        if (arrayToPrint_ != null) {
            printArray(arrayToPrint_)
        }
    }

    protected fun startup(numRun_: Int, name_: String, algorithm: Algorithm) {
        algorithm.resetVariables()
        printStartText(name_, numRun_)
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

    protected fun getCommonSection(name_: String, numRun_: Int): String {
        var commonSection = "$name_ $NEWLINE"
        commonSection += TAB
        commonSection += if (numRun_ == ONE){
            "Ran once. $NEWLINE"
        }else{
            "Ran $numRun_ times. $NEWLINE"
        }
        commonSection += TAB + getDuration()
        return commonSection
    }

    protected fun getDuration(): String {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / AlgorithmConstants.THOUSAND).toDouble()
        return "It took " + getTimeString(time)
    }

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
}