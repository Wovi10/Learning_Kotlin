import algorithms.searches.BinarySearch
import algorithms.searches.EmptySearch
import algorithms.searches.LinearSearch
import algorithms.searches.Searches.runSearches
import algorithms.sorts.*
import algorithms.sorts.Sorts.runSorts
import interactive_Projects.Quiz
import utils.Constants.EMPTY_STRING
import utils.Constants.ONE
import utils.Constants.TWO
import utils.Constants.ZERO

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
    russianPeasant(99,99)
//    searchAndSorts()
//    interActiveProjects()
}

fun russianPeasant(firstNum: Int, multiplier: Int) {
    val answer = calculate(firstNum, multiplier)
    printAnswer(answer)
}

fun printAnswer(answer: Int) {
    println("The answer is: $answer")
}

fun calculate(firstNum_: Int, multiplier_: Int): Int {
    var firstNum = firstNum_
    var multiplier = multiplier_
    var sum = ZERO
    if (firstNum % TWO != ZERO){
        sum += multiplier
    }
    while (firstNum >= ONE){
        firstNum /= TWO
        multiplier *= TWO
        if (firstNum % TWO != ZERO){
            sum += multiplier
        }
    }
    return sum
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
