package consoleInteraction.utils

import consoleInteraction.utils.Constants.Ansi.CursorNavigation.ANSI_ESCAPE

object Constants {

    object Ansi{
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
        object CursorNavigation{
            const val ANSI_ESCAPE = "\u001b["
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
    }
}