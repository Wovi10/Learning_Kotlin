package utils

object Constants {
    const val ZERO = 0
    const val ONE = 1

    const val NEWLINE = "\n"
    const val TAB = "\t"
    const val EMPTY_STRING = ""
    const val SPACE = " "
    const val HASHTAG = "#"
    const val ANSI_ESCAPE = "\u001b["
    object AnsiColours {
        const val BLACK = 0
        const val RED = 1
        const val GREEN = 2
        const val YELLOW = 3
        const val BLUE = 4
        const val MAGENTA = 5
        const val CYAN = 6
        const val WHITE = 7
    }
    object AnsiDirections{
        const val UP = "A"
        const val DOWN = "B"
        const val RIGHT = "C"
        const val LEFT = "D"
    }
}