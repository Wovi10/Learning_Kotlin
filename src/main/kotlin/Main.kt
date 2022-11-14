import algorithms.searches.BinarySearch
import algorithms.searches.EmptySearch
import algorithms.searches.LinearSearch
import algorithms.searches.Searches.runSearches
import algorithms.sorts.*
import algorithms.sorts.Sorts.runSorts
import interactive_Projects.Quiz
import utils.Constants.EMPTY_STRING

val sortList = listOf(BogoSort, BubbleSort, InsertionSort, QuickSort, RadixSort, SelectionSort, MergeSort, HeapSort)
val skipSortList = listOf(EmptySort, BogoSort, QuickSort, RadixSort)

val searchList = listOf(BinarySearch, LinearSearch)
val skipSearchList = listOf(EmptySearch, BinarySearch, LinearSearch)

const val arraySize = 100000
const val lowestVal = 0
const val highestVal = 100
const val sort_numRun = 1000
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
    val informationToShow = mutableListOf(EMPTY_STRING)

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
