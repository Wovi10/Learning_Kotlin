package utils.console

import algorithms.utils.AlgorithmConstants.HUNDRED
import utils.Constants.EMPTY_STRING
import utils.Constants.HASHTAG
import utils.Constants.NEWLINE
import utils.Constants.ONE
import utils.Constants.REVERT
import utils.Constants.SPACE
import utils.console.RichText.FOREGROUND_BLUE
import utils.console.RichText.FOREGROUND_GREEN_BRIGHT
import utils.console.RichText.RESET

private const val MAX_NUM_HASHTAGS = 25

private const val DONE_MESSAGE = "Done!"

object AsciiProgressBar {
    fun updateProgressBar(index: Int, total: Int){
        val contentToPrint: String
        val percentage = (index* HUNDRED)/total
        if (percentage + ONE == HUNDRED){
            contentToPrint = FOREGROUND_GREEN_BRIGHT + DONE_MESSAGE + fillBarWithSpaces() + NEWLINE
        }else{
            val width = (percentage + ONE)/(HUNDRED/ MAX_NUM_HASHTAGS)
            var hashtags = EMPTY_STRING
            repeat(width){
                hashtags += HASHTAG
            }
            var spaces = EMPTY_STRING
            repeat(MAX_NUM_HASHTAGS - width){
                spaces += SPACE
            }
            contentToPrint = "$FOREGROUND_BLUE[$hashtags$spaces]"
        }
        print(REVERT + contentToPrint + RESET)
    }

    private fun fillBarWithSpaces(): String {
        var output = ""
        repeat(MAX_NUM_HASHTAGS - DONE_MESSAGE.length){
            output += SPACE
        }
        return output
    }
}