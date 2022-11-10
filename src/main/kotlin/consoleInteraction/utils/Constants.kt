package consoleInteraction.utils

object Constants {

    object Ansi {
        const val ANSI_ESCAPE = "\u001b["
        object RichText {
            private const val BLACK = 0
            private const val RED = 1
            private const val GREEN = 2
            private const val YELLOW = 3
            private const val BLUE = 4
            private const val MAGENTA = 5
            private const val CYAN = 6
            private const val WHITE = 7

            private const val FOREGROUND = ANSI_ESCAPE + "3"
            private const val BACKGROUND = ANSI_ESCAPE + "4"
            private const val DEFAULT = "m"
            private const val BRIGHT = ";1$DEFAULT"

            const val TEXT_STYLE_RESET = ANSI_ESCAPE + "0$DEFAULT"
            const val BOLD = ANSI_ESCAPE + "1$DEFAULT"
            const val UNDERLINE = ANSI_ESCAPE + "4$DEFAULT"
            const val REVERSED = ANSI_ESCAPE + "7$DEFAULT"

            const val FOREGROUND_BLACK = FOREGROUND + BLACK + DEFAULT
            const val FOREGROUND_RED = FOREGROUND + RED + DEFAULT
            const val FOREGROUND_GREEN = FOREGROUND + GREEN + DEFAULT
            const val FOREGROUND_YELLOW = FOREGROUND + YELLOW + DEFAULT
            const val FOREGROUND_BLUE = FOREGROUND + BLUE + DEFAULT
            const val FOREGROUND_MAGENTA = FOREGROUND + MAGENTA + DEFAULT
            const val FOREGROUND_CYAN = FOREGROUND + CYAN + DEFAULT
            const val FOREGROUND_WHITE = FOREGROUND + WHITE + DEFAULT

            const val FOREGROUND_BLACK_BRIGHT = FOREGROUND + BLACK + BRIGHT
            const val FOREGROUND_RED_BRIGHT = FOREGROUND + RED + BRIGHT
            const val FOREGROUND_GREEN_BRIGHT = FOREGROUND + GREEN + BRIGHT
            const val FOREGROUND_YELLOW_BRIGHT = FOREGROUND + YELLOW + BRIGHT
            const val FOREGROUND_BLUE_BRIGHT = FOREGROUND + BLUE + BRIGHT
            const val FOREGROUND_MAGENTA_BRIGHT = FOREGROUND + MAGENTA + BRIGHT
            const val FOREGROUND_CYAN_BRIGHT = FOREGROUND + CYAN + BRIGHT
            const val FOREGROUND_WHITE_BRIGHT = FOREGROUND + WHITE + BRIGHT

            const val BACKGROUND_BLACK = BACKGROUND + BLACK + DEFAULT
            const val BACKGROUND_RED = BACKGROUND + RED + DEFAULT
            const val BACKGROUND_GREEN = BACKGROUND + GREEN + DEFAULT
            const val BACKGROUND_YELLOW = BACKGROUND + YELLOW + DEFAULT
            const val BACKGROUND_BLUE = BACKGROUND + BLUE + DEFAULT
            const val BACKGROUND_MAGENTA = BACKGROUND + MAGENTA + DEFAULT
            const val BACKGROUND_CYAN = BACKGROUND + CYAN + DEFAULT
            const val BACKGROUND_WHITE = BACKGROUND + WHITE + DEFAULT

            const val BACKGROUND_BLACK_BRIGHT = BACKGROUND + BLACK + BRIGHT
            const val BACKGROUND_RED_BRIGHT = BACKGROUND + RED + BRIGHT
            const val BACKGROUND_GREEN_BRIGHT = BACKGROUND + GREEN + BRIGHT
            const val BACKGROUND_YELLOW_BRIGHT = BACKGROUND + YELLOW + BRIGHT
            const val BACKGROUND_BLUE_BRIGHT = BACKGROUND + BLUE + BRIGHT
            const val BACKGROUND_MAGENTA_BRIGHT = BACKGROUND + MAGENTA + BRIGHT
            const val BACKGROUND_CYAN_BRIGHT = BACKGROUND + CYAN + BRIGHT
            const val BACKGROUND_WHITE_BRIGHT = BACKGROUND + WHITE + BRIGHT
        }

        object AnsiDirections {
            const val UP = "A"
            const val DOWN = "B"
            const val RIGHT = "C"
            const val LEFT = "D"
        }
    }
}