package searchAndReplace

/**
 * This class was used to try structural search and replace in Kotlin
 */
class Point constructor(locationX: Int, locationY: Int) {
    val x: Int  = locationX
    val y: Int  = locationY
}

open class OpenClass{
    open val openProperty = 0
    open fun display(){
        println("Some text")
        print("More text")
        print(0)
    }
}