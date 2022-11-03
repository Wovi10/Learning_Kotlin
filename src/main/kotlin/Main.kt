
import algorithms.sorts.QuickSort
import algorithms.sorts.RadixSort
import algorithms.utils.Utils

fun main() {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")

    val arraySize = 1000; val lowestVal = 0; val highestVal = 1000; val numRun = 1

//    BinarySearch.search(0, 100, 100)
//    LinearSearch.search(0, 100, 100)
//
//    QuickSort.sort(arraySize, lowestVal, highestVal, numRun)
//    RadixSort.sort(arraySize, lowestVal, highestVal, numRun)
//    SelectionSort.sort(arraySize, lowestVal, highestVal, numRun)

    val quickArrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
    val radixArrayToSort = Utils.copyArray(quickArrayToSort)
    QuickSort.sort(quickArrayToSort)
    RadixSort.sort(radixArrayToSort)
}