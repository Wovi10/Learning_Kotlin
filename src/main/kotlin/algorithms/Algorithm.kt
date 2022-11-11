package algorithms

import consoleInteraction.AsciiProgressBar.drawProgressBar
import utils.Constants.EMPTY_STRING
import utils.Constants.ONE
import utils.Constants.TAB
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private const val SIXTY = 60
private const val THOUSAND = 1000
private const val ONE_MILLION = 1000000

abstract class Algorithm {
    protected abstract var startTime: LocalDateTime

    abstract fun resetVariables()

    open fun updateProgressBar(runNum: Int, numRun_: Int) {
        val durationText: String = if (runNum + ONE == numRun_) getDuration()
        else EMPTY_STRING
        drawProgressBar(runNum, numRun_, durationText)
    }

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