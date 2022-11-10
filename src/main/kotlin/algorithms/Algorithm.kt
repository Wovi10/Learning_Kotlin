package algorithms

import algorithms.utils.Constants.ONE_MILLION
import algorithms.utils.Constants.SIXTY
import algorithms.utils.Constants.THOUSAND
import utils.Constants.EMPTY_STRING
import utils.Constants.TAB
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

abstract class Algorithm {
    protected abstract var startTime: LocalDateTime

    abstract fun resetVariables()

    private fun printStartText(name_: String, arrayToPrint_: IntArray? = null) {
        println(TAB + name_)
        if (arrayToPrint_ != null) printArray(arrayToPrint_)
    }

    protected fun startup(name_: String, algorithm: Algorithm, arrayToPrint_: IntArray? = null) {
        algorithm.resetVariables()
        printStartText(name_, arrayToPrint_)
    }

    private fun printArray(arrayToPrint_: IntArray) {
        var stringToPrint = EMPTY_STRING
        for (i in arrayToPrint_.indices) {
            val indexToPrint = arrayToPrint_[i]

            if (stringToPrint.isNotEmpty()) stringToPrint += ", "
            stringToPrint += indexToPrint.toString()
        }
        println(stringToPrint)
    }

    fun getDuration(): String {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / THOUSAND).toDouble()
        return getTimeString(time)
    }

    private fun getTimeString(_time: Double): String {
        var time = _time
        time /= ONE_MILLION
        if (time < SIXTY) return "$time seconds"

        time /= SIXTY
        if (time < SIXTY) return "$time minutes"

        time /= SIXTY
        return "$time hours"
    }
}