import algorithms.searches.BinarySearch
import algorithms.searches.LinearSearch
import algorithms.searches.Searches.runSearchesMultipleTimes
import algorithms.searches.Searches.runSearchesOnce
import algorithms.sorts.*
import algorithms.sorts.Sorts.runAllSortsMultipleTimes
import algorithms.sorts.Sorts.runAllSortsOnce
import interactive_Projects.Quiz

val sortList = listOf(QuickSort, RadixSort, SelectionSort, InsertionSort, BubbleSort)
val skipSortList = listOf(QuickSort, RadixSort, SelectionSort, InsertionSort)

val searchList = listOf(BinarySearch, LinearSearch)
val skipSearchList = listOf(BinarySearch, LinearSearch)

const val arraySize = 10000
const val lowestVal = 0
const val highestVal = 99
const val numRun = 100

fun main() {
    searchAndSorts()
//    interActiveProjects()
}

fun interActiveProjects() {
    quiz()
}

fun quiz() {
    val quiz = Quiz(2)
    quiz.runQuiz()
}

fun searchAndSorts() {
    val informationToShow = mutableListOf("Results of this run:")

    informationToShow.add(runSearchesMultipleTimes())
//    informationToShow.add(runSearchesOnce())

    informationToShow.add(runAllSortsMultipleTimes())
    informationToShow.add(runAllSortsOnce())

    printInformationToShow(informationToShow)
}

fun printInformationToShow(informationToShow: MutableList<String>) {
    println()
    println()
    for (info in informationToShow) {
        println(info)
        println()
    }
}
