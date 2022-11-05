import algorithms.searches.BinarySearch
import algorithms.searches.LinearSearch
import algorithms.sorts.*
import algorithms.utils.Utils

fun main() {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")
    val sortList = listOf(QuickSort, RadixSort, SelectionSort, InsertionSort, BubbleSort)
    val skipSortList = listOf(SelectionSort, InsertionSort)

    val searchList = listOf(BinarySearch, LinearSearch)
    val skipSearchList  = listOf(BinarySearch, LinearSearch)

    val arraySize = 1000000; val lowestVal = 0; val highestVal = 99; val numRun = 100

    for (searchType in searchList) {
        if (skipSearchList.contains(searchType))
            continue
        searchType.search(lowestVal, highestVal, numRun)
    }

//    for (sortType in sortList) {
//        if (skipSortList.contains(sortType))
//            continue
//        sortType.sort(arraySize, lowestVal, highestVal, numRun)
//    }

    for (sortType in sortList) {
        if (skipSortList.contains(sortType))
            continue
        val arrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
        sortType.sort(arrayToSort)
    }
}