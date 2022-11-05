import algorithms.searches.Searches.runSearchesMultipleTimes
import algorithms.searches.Searches.runSearchesOnce
import algorithms.sorts.Sorts.runAllSortsMultipleTimes
import algorithms.sorts.Sorts.runAllSortsOnce


const val arraySize = 1000;
const val lowestVal = 0;
const val highestVal = 99;
const val numRun = 100

fun main() {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")

    val informationToShow = mutableListOf("Results of this run:")

    informationToShow.add(runSearchesMultipleTimes())
    informationToShow.add(runSearchesOnce())

    informationToShow.add(runAllSortsMultipleTimes())
    informationToShow.add(runAllSortsOnce())

    printInformationToShow(informationToShow)
}

fun printInformationToShow(informationToShow: MutableList<String>) {
    for (info in informationToShow) {
        println(info)
        println()
    }
}
