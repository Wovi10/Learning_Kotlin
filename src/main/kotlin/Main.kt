import Algroythms.Algorythms

fun main(args: Array<String>) {
//    println("What is you name?")
//    val name = readln()
//    println("Hello, $name")

    var numTries = 0
    val numRuns = 1000
    for (x in 0..(numRuns+1)) {
        numTries += Algorythms.binarySearch(0, 100)
    }
    println(numTries/numRuns)

}