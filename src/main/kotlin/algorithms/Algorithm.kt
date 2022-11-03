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

    open fun printStartText(arrayToPrint: IntArray, name: String){
        println("Sorting following array with $name:")
        printArray(arrayToPrint)
    }

    open fun printArray(arrayToPrint: IntArray) {
        var stringToPrint = ""
        for (i in arrayToPrint.indices) {
            val indexToPrint = arrayToPrint[i]
            if (stringToPrint.isNotEmpty()){
                stringToPrint += ", $indexToPrint"
            }else{
                stringToPrint = indexToPrint.toString()
            }
        }
        println(stringToPrint)
    }

    open fun printCommonSection(name: String, numRun: Int) {
        println("Ran $name $numRun times.")
        printDuration()
    }

    open fun printDuration() {
        val stopTime: LocalDateTime = LocalDateTime.now()
        val time = (startTime.until(stopTime, ChronoUnit.NANOS) / AlgorithmConstants.THOUSAND).toDouble()
        val timeString = "It took " + getTimeString(time)
        println(timeString)
    }

    abstract fun resetVariables()
}