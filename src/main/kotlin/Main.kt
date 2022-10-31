import algorithms.searches.BinarySearch
import algorithms.searches.LinearSearch
import algorithms.sorts.SelectionSort

fun main(args: Array<String>) {
//    println("What is your name?")
//    val name = readln()
//    println("Hello, $name")

    BinarySearch.search(0, 100, 100)
    LinearSearch.search(0, 100, 100)
    SelectionSort.sort(100, 0, 100, 100)
}