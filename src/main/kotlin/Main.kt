import algorithms.searches.BinarySearch
import algorithms.searches.LinearSearch
import algorithms.sorts.QuickSort
import algorithms.sorts.SelectionSort

fun main(args: Array<String>) {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")

//    BinarySearch.search(0, 100, 100)
//    LinearSearch.search(0, 100, 100)
    SelectionSort.sort(20, 0, 1000, 1)
    QuickSort.sort(20, 0, 100, 1)
}