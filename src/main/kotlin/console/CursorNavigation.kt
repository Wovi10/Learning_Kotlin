package console

import utils.Constants.AnsiDirections.DOWN
import utils.Constants.AnsiDirections.LEFT
import utils.Constants.AnsiDirections.RIGHT
import utils.Constants.AnsiDirections.UP
import utils.Constants.Console.ANSI_ESCAPE

object CursorNavigation {

    fun moveUp(numPlaces: Int) = movePlaces(numPlaces) + UP

    fun moveDown(numPlaces: Int) = movePlaces(numPlaces) + DOWN

    fun moveLeft(numPlaces: Int) = movePlaces(numPlaces) + LEFT

    fun moveRight(numPlaces: Int) = movePlaces(numPlaces) + RIGHT

    private fun movePlaces(numPlaces: Int) = "$ANSI_ESCAPE$numPlaces"
}