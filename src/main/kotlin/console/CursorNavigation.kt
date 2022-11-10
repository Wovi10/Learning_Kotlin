package console

import console.utils.Constants.Ansi.AnsiDirections.DOWN
import console.utils.Constants.Ansi.AnsiDirections.LEFT
import console.utils.Constants.Ansi.AnsiDirections.RIGHT
import console.utils.Constants.Ansi.AnsiDirections.UP
import console.utils.Constants.Ansi.CursorNavigation.ANSI_ESCAPE

object CursorNavigation {
    fun moveUp(numPlaces: Int) = movePlaces(numPlaces) + UP

    fun moveDown(numPlaces: Int) = movePlaces(numPlaces) + DOWN

    fun moveLeft(numPlaces: Int) = movePlaces(numPlaces) + LEFT

    fun moveRight(numPlaces: Int) = movePlaces(numPlaces) + RIGHT

    private fun movePlaces(numPlaces: Int) = "$ANSI_ESCAPE$numPlaces"
}