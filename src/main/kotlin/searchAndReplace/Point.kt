package searchAndReplace

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