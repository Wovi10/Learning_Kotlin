package utils.console

import utils.Constants.EMPTY_STRING
import utils.Constants.SPACE
import utils.console.CursorNavigation.moveLeft

object AsciiProgressBar {
    fun updateProgressBar(index: Int){
        val width = (index + 1) / 4
        var hashtags = EMPTY_STRING
        repeat(width){
            hashtags += "#"
        }
        var spaces = EMPTY_STRING
        repeat(25 - width){
            spaces += SPACE
        }
        val bar = "[$hashtags$spaces]"
        print(moveLeft(1000) + bar)
    }
}