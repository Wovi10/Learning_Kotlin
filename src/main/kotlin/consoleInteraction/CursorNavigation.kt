package consoleInteraction

import consoleInteraction.utils.Constants.Ansi.ANSI_ESCAPE
import consoleInteraction.utils.Constants.Ansi.AnsiDirections.DOWN
import consoleInteraction.utils.Constants.Ansi.AnsiDirections.LEFT
import consoleInteraction.utils.Constants.Ansi.AnsiDirections.RIGHT
import consoleInteraction.utils.Constants.Ansi.AnsiDirections.UP

object CursorNavigation {
    fun moveUp(numPlaces: Int) = movePlaces(numPlaces) + UP

    fun moveDown(numPlaces: Int) = movePlaces(numPlaces) + DOWN

    fun moveLeft(numPlaces: Int) = movePlaces(numPlaces) + LEFT

    fun moveRight(numPlaces: Int) = movePlaces(numPlaces) + RIGHT

    private fun movePlaces(numPlaces: Int) = "$ANSI_ESCAPE$numPlaces"
}