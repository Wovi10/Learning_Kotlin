import algorithms.sorts.QuickSort
import algorithms.sorts.RadixSort
import algorithms.sorts.SelectionSort

fun main(args: Array<String>) {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")

    val arraySize = 100000; val lowestVal = 0; val highestVal = 1000; val numRun = 100

//    BinarySearch.search(0, 100, 100)
//    LinearSearch.search(0, 100, 100)

    QuickSort.sort(arraySize, lowestVal, highestVal, numRun)
    RadixSort.sort(arraySize, lowestVal, highestVal, numRun)
//    SelectionSort.sort(arraySize, lowestVal, highestVal, numRun)
}