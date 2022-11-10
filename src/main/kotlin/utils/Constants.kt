package utils

import utils.Constants.Console.ANSI_ESCAPE

object Constants {
    const val ZERO = 0
    const val ONE = 1

    const val NEWLINE = "\n"
    const val TAB = "\t"
    const val EMPTY_STRING = ""
    const val SPACE = " "

    object InteractiveProjects{
        const val TEN = 10
    }

    object Console{
        const val ANSI_ESCAPE = "\u001b["

        object ProgressBar{
            const val HASHTAG = "#"
            const val REVERT = "\r"
        }
    }

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

    object Algorithm{
        const val TWO = 2
        const val SIXTY = 60
        const val HUNDRED = 100
        const val THOUSAND = 1000
        const val ONE_MILLION = 1000000

        const val NUMBER_BASE = 10

        object SearchTypes{
            private const val SEARCH_TEXT = "search"
            const val BINARYSEARCH_TEXT = "Binary $SEARCH_TEXT"
            const val LINEARSEARCH_TEXT = "Linear $SEARCH_TEXT"
            const val EMPTYSEARCH_TEXT = "Empty $SEARCH_TEXT"
        }

        object SortTypes{
            private const val SORT_TEXT = "sort"
            const val BUBBLESORT_TEXT = "Bubble $SORT_TEXT"
            const val INSERTIONSORT_TEXT = "Insertion $SORT_TEXT"
            const val QUICKSORT_TEXT = "Quick $SORT_TEXT"
            const val RADIXSORT_TEXT = "Radix $SORT_TEXT"
            const val SELECTIONSORT_TEXT = "Selection $SORT_TEXT"
            const val EMPTYSORT_TEXT = "Empty $SORT_TEXT"
        }
    }

    object Calculator{
        const val PRODUCT_OPERAND = "*"
        const val DIVISION_OPERAND = "/"
        const val SUM_OPERAND = "+"
        const val SUBTRACTION_OPERAND = "-"
    }

    object RichText {
        private const val FOREGROUND = ANSI_ESCAPE + "3"
        private const val BACKGROUND = ANSI_ESCAPE + "4"
        private const val DEFAULT = "m"
        private const val BRIGHT = ";1$DEFAULT"

        const val TEXT_STYLE_RESET = ANSI_ESCAPE + "0$DEFAULT"
        const val BOLD = ANSI_ESCAPE + "1$DEFAULT"
        const val UNDERLINE = ANSI_ESCAPE + "4$DEFAULT"
        const val REVERSED = ANSI_ESCAPE + "7$DEFAULT"

        const val FOREGROUND_BLACK = FOREGROUND + AnsiColours.BLACK + DEFAULT
        const val FOREGROUND_RED = FOREGROUND + AnsiColours.RED + DEFAULT
        const val FOREGROUND_GREEN = FOREGROUND + AnsiColours.GREEN + DEFAULT
        const val FOREGROUND_YELLOW = FOREGROUND + AnsiColours.YELLOW + DEFAULT
        const val FOREGROUND_BLUE = FOREGROUND + AnsiColours.BLUE + DEFAULT
        const val FOREGROUND_MAGENTA = FOREGROUND + AnsiColours.MAGENTA + DEFAULT
        const val FOREGROUND_CYAN = FOREGROUND + AnsiColours.CYAN + DEFAULT
        const val FOREGROUND_WHITE = FOREGROUND + AnsiColours.WHITE + DEFAULT

        const val FOREGROUND_BLACK_BRIGHT = FOREGROUND + AnsiColours.BLACK + BRIGHT
        const val FOREGROUND_RED_BRIGHT = FOREGROUND + AnsiColours.RED + BRIGHT
        const val FOREGROUND_GREEN_BRIGHT = FOREGROUND + AnsiColours.GREEN + BRIGHT
        const val FOREGROUND_YELLOW_BRIGHT = FOREGROUND + AnsiColours.YELLOW + BRIGHT
        const val FOREGROUND_BLUE_BRIGHT = FOREGROUND + AnsiColours.BLUE + BRIGHT
        const val FOREGROUND_MAGENTA_BRIGHT = FOREGROUND + AnsiColours.MAGENTA + BRIGHT
        const val FOREGROUND_CYAN_BRIGHT = FOREGROUND + AnsiColours.CYAN + BRIGHT
        const val FOREGROUND_WHITE_BRIGHT = FOREGROUND + AnsiColours.WHITE + BRIGHT

        const val BACKGROUND_BLACK = BACKGROUND + AnsiColours.BLACK + DEFAULT
        const val BACKGROUND_RED = BACKGROUND + AnsiColours.RED + DEFAULT
        const val BACKGROUND_GREEN = BACKGROUND + AnsiColours.GREEN + DEFAULT
        const val BACKGROUND_YELLOW = BACKGROUND + AnsiColours.YELLOW + DEFAULT
        const val BACKGROUND_BLUE = BACKGROUND + AnsiColours.BLUE + DEFAULT
        const val BACKGROUND_MAGENTA = BACKGROUND + AnsiColours.MAGENTA + DEFAULT
        const val BACKGROUND_CYAN = BACKGROUND + AnsiColours.CYAN + DEFAULT
        const val BACKGROUND_WHITE = BACKGROUND + AnsiColours.WHITE + DEFAULT

        const val BACKGROUND_BLACK_BRIGHT = BACKGROUND + AnsiColours.BLACK + BRIGHT
        const val BACKGROUND_RED_BRIGHT = BACKGROUND + AnsiColours.RED + BRIGHT
        const val BACKGROUND_GREEN_BRIGHT = BACKGROUND + AnsiColours.GREEN + BRIGHT
        const val BACKGROUND_YELLOW_BRIGHT = BACKGROUND + AnsiColours.YELLOW + BRIGHT
        const val BACKGROUND_BLUE_BRIGHT = BACKGROUND + AnsiColours.BLUE + BRIGHT
        const val BACKGROUND_MAGENTA_BRIGHT = BACKGROUND + AnsiColours.MAGENTA + BRIGHT
        const val BACKGROUND_CYAN_BRIGHT = BACKGROUND + AnsiColours.CYAN + BRIGHT
        const val BACKGROUND_WHITE_BRIGHT = BACKGROUND + AnsiColours.WHITE + BRIGHT
    }
}