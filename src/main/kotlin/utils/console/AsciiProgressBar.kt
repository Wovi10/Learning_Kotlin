package utils.console

import algorithms.utils.AlgorithmConstants.HUNDRED
import utils.Constants.EMPTY_STRING
import utils.Constants.HASHTAG
import utils.Constants.ONE
import utils.Constants.REVERT
import utils.Constants.SPACE
import utils.console.RichText.FOREGROUND_BLUE
import utils.console.RichText.FOREGROUND_GREEN_BRIGHT
import utils.console.RichText.RESET

private const val MAX_NUM_HASHTAGS = 25

object AsciiProgressBar {
    fun updateProgressBar(index: Int, total: Int){
        val percentage = (index* HUNDRED)/total
        if (percentage + ONE == HUNDRED){
            print(REVERT + FOREGROUND_GREEN_BRIGHT + "Done!" + RESET)
            return
        }
        val width = (percentage + ONE)/(HUNDRED/ MAX_NUM_HASHTAGS)
        var hashtags = EMPTY_STRING
        repeat(width){
            hashtags += HASHTAG
        }
        var spaces = EMPTY_STRING
        repeat(MAX_NUM_HASHTAGS - width){
            spaces += SPACE
        }
        val bar = "[$hashtags$spaces]"
        print(REVERT + FOREGROUND_BLUE + bar + RESET)
    }
}