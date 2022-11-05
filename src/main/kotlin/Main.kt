import algorithms.sorts.Sorts.runAllSortsOnce
import algorithms.searches.BinarySearch
import algorithms.searches.LinearSearch
import algorithms.searches.Searches.runSearchesMultipleTimes


const val arraySize = 1000000;
const val lowestVal = 0;
const val highestVal = 99;
const val numRun = 100

fun main() {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")


    runSearchesMultipleTimes()

//    runAllSortsMultipleTimes()
    runAllSortsOnce()
}