import algorithms.searches.BinarySearch
import algorithms.searches.LinearSearch
import algorithms.sorts.*
import algorithms.utils.Utils

fun main() {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")

    val arraySize = 20; val lowestVal = 0; val highestVal = 99; val numRun = 100

//    BinarySearch.search(0, 100, 100)
//    LinearSearch.search(0, 100, 100)

//    QuickSort.sort(arraySize, lowestVal, highestVal, numRun)
//    RadixSort.sort(arraySize, lowestVal, highestVal, numRun)
//    SelectionSort.sort(arraySize, lowestVal, highestVal, numRun)
//    InsertionSort.sort(arraySize, lowestVal, highestVal, numRun)

//    val quickArrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
//    QuickSort.sort(quickArrayToSort)
//    val radixArrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
//    RadixSort.sort(radixArrayToSort)
//    val selectionArrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
//    SelectionSort.sort(selectionArrayToSort)
//    val insertionArrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
//    InsertionSort.sort(insertionArrayToSort)
    val bubbleArrayToSort = Utils.createInputArray(arraySize, lowestVal, highestVal)
    BubbleSort.sort(bubbleArrayToSort)

}