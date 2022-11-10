import algorithms.searches.BinarySearch
import algorithms.searches.EmptySearch
import algorithms.searches.LinearSearch
import algorithms.searches.Searches.runSearches
import algorithms.sorts.*
import algorithms.sorts.Sorts.runSorts
import interactive_Projects.Quiz

val sortList = listOf(QuickSort, RadixSort, SelectionSort, InsertionSort, BubbleSort)
val skipSortList = listOf(EmptySort)

val searchList = listOf(BinarySearch, LinearSearch)
val skipSearchList = listOf(BinarySearch, LinearSearch, EmptySearch)

const val arraySize = 10000
const val lowestVal = 0
const val highestVal = 99
const val sort_numRun = 100
const val search_numRun = 100

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

    informationToShow.add(runSorts())
    informationToShow.add(runSearches())

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
