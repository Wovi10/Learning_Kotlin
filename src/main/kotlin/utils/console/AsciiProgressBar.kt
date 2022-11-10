package utils.console

import algorithms.utils.AlgorithmConstants.HUNDRED
import utils.Constants.EMPTY_STRING
import utils.Constants.HASHTAG
import utils.Constants.NEWLINE
import utils.Constants.ONE
import utils.Constants.REVERT
import utils.Constants.SPACE
import utils.Constants.TAB
import utils.console.RichText.FOREGROUND_BLUE
import utils.console.RichText.FOREGROUND_GREEN_BRIGHT
import utils.console.RichText.TEXT_STYLE_RESET

private const val MAX_NUM_HASHTAGS = 25

private const val DONE_MESSAGE = "Done!"

object AsciiProgressBar {
    fun updateProgressBar(index: Int, total: Int, durationText_: String) {
        val contentToPrint: String
        val percentage = (index*100 / total)
        if (index + ONE == total) {
            val durationText = TAB + durationText_
            val spaces = fillBarWithSpaces(durationText.length)
            contentToPrint =
                FOREGROUND_GREEN_BRIGHT + DONE_MESSAGE + TEXT_STYLE_RESET + durationText + spaces + NEWLINE
        } else {
            val width = (percentage + ONE) / (HUNDRED / MAX_NUM_HASHTAGS)
            var hashtags = EMPTY_STRING
            repeat(width) {
                hashtags += HASHTAG
            }
            var spaces = EMPTY_STRING
            repeat(MAX_NUM_HASHTAGS - width) {
                spaces += SPACE
            }
            contentToPrint = "$FOREGROUND_BLUE[$hashtags$spaces]$TEXT_STYLE_RESET"
        }
        print(REVERT + TAB + TAB + contentToPrint)
    }

    private fun fillBarWithSpaces(durationText_Length_: Int): String {
        var output = ""
        val times = MAX_NUM_HASHTAGS - DONE_MESSAGE.length - durationText_Length_
        repeat(times) {
            output += SPACE
        }
        return output
    }
}